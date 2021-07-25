package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.models.entity.dto.UserSeedDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_FILE_PATH = "src/main/resources/files/users.json";

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final PictureService pictureService;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository, PictureService pictureService, ValidatorUtil validatorUtil, ModelMapper modelMapper, Gson gson) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.pictureService = pictureService;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public Boolean аreImported() {
        return userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(USER_FILE_PATH));
    }

    @Override
    public String importUsers() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), UserSeedDto[].class))
                .filter(userSeedDto -> {

                    boolean isValid = validatorUtil.isValid(userSeedDto)
                            && !userRepository.existsByUsername(userSeedDto.getUsername())
                            && pictureRepository.existsByPath(userSeedDto.getProfilePicture());
                    sb.append(isValid ? String.format("Successfully imported User: %s",
                            userSeedDto.getUsername()) : "Invalid User")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(userSeedDto -> {
                    User user = modelMapper.map(userSeedDto, User.class);
                    user.setProfilePicture(pictureService.findByPath(userSeedDto.getProfilePicture()));
                    return user;
                })
                .forEach(userRepository::save);

        return sb.toString();
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public String exportUsersWithTheirPosts() {

        StringBuilder sb = new StringBuilder();

        userRepository.findAllOrderByPostCountDescThenById()
                .forEach(user -> {
                    sb.append(String.format("User: %s\n" +
                            "Post count: %d", user.getUsername(), user.getPosts().size()))
                            .append(System.lineSeparator());
                    user.getPosts().forEach(post -> {
                        sb.append(String.format("==Post Details:\n" +
                                "----Caption: %s\n" +
                                "----Picture Size: %.2f", post.getCaption(), post.getPicture().getSize()))
                                .append(System.lineSeparator());
                    });
                });


        return sb.toString();
    }
}
