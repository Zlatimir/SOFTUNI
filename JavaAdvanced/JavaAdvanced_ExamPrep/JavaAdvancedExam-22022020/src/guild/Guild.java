package guild;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 4.2.2021 г..
 */

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player){
        if (this.roster.size() <= this.capacity){
            roster.add(player);
        }
    }

    public int count(){
        return this.roster.size();
    }

    public boolean removePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                return this.roster.remove(player);
            }
        }
        return false;
    }

    public void promotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                player.setRank("Member");
                break;
            }
        }
    }

    public String report(){
        String str = "Players in the guild: " + this.name + ":" + System.lineSeparator();
        for (Player player : roster) {
            str += player + System.lineSeparator();
        }
        return str;
    }
//
//    List<Object> objs;
//    Iterator<Object> i = objs.iterator();
//      while (i.hasNext()) {
//        Object o = i.next();
//        //some condition
//        i.remove();
//    }
    public Player[] kickPlayersByClass(String clazz){
        List<Player> kicked = new ArrayList<>();
        Iterator<Player> iterator = roster.iterator();
        while (iterator.hasNext()){
            Player player = iterator.next();
            if (player.getClazz().equals(clazz)){
                kicked.add(player);
                iterator.remove();
            }
        }
        int n = kicked.size();
        Player[] arrayOfKicked = new Player[n];
        for (int i = 0; i < n; i++) {
            arrayOfKicked[i] = kicked.get(i);
        }
        return arrayOfKicked;
    }

    public void demotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)){
                player.setRank("Trial");
                break;
            }
        }
    }

}
