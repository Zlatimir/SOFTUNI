package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.dto.PostSeedRootDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    private static final String POST_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final XmlParser xmlParser;
    private final PictureService pictureService;
    private final UserService userService;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, PictureRepository pictureRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, XmlParser xmlParser, PictureService pictureService, UserService userService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.pictureService = pictureService;
        this.userService = userService;
    }

    @Override
    public Boolean аreImported() {
        return postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(POST_FILE_PATH));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(PostSeedRootDto.class, POST_FILE_PATH)
                .getPosts().stream()
                .filter(postSeedDto -> {
                    boolean isValid = validatorUtil.isValid(postSeedDto)
                            && userRepository.existsByUsername(postSeedDto.getUser().getUsername())
                            && pictureRepository.existsByPath(postSeedDto.getPicture().getPath());

                    sb.append(isValid ? String.format("Successfully imported Post, made by %s", postSeedDto.getUser().getUsername())
                            : "Invalid Post")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(postSeedDto -> {
                    Post post = modelMapper.map(postSeedDto, Post.class);
                    post.setUser(userService.findByName(postSeedDto.getUser().getUsername()));
                    post.setPicture(pictureService.findByPath(postSeedDto.getPicture().getPath()));
                    return post;
                })
                .forEach(postRepository::save);

        return sb.toString();
    }
}
