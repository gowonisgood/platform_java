package PNUFootballGame0903;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileRepository implements IRepository {
    private final String fileName = "C:\\Users\\gowon\\Desktop\\Exeption_File_IO\\src\\Re_PNUFootballGame0903\\player.csv";
    private final Map<Integer, Player> players = new HashMap<>();
    private String header;
    private int nextId;

    public FileRepository() {
        load();
        nextId = calculateNextId();
    }

    private void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    header = line; // Store the header
                    isFirstLine = false;
                } else {
                    try {
                        Player player = Player.fromString(line);
                        if (player != null) {
                            players.put(player.getSofifaId(), player);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(header);
            writer.newLine();

            for (Player player : players.values()) {
                writer.write(player.toString());
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private int calculateNextId() {
        int maxId = 0;
        for (Player player : players.values()) {
            if (player.getSofifaId() > maxId) {
                maxId = player.getSofifaId();
            }
        }
        return maxId + 1;
    }

    @Override
    public void addPlayer(Player player) {
        player.setSofifaId(nextId++);
        players.put(player.getSofifaId(), player);
        save();
    }

    @Override
    public boolean deletePlayer(int playerId) {
        if (players.remove(playerId) != null) {
            save();
            return true;
        }
        return false;
    }

    @Override
    public Player getPlayer(int playerId) {
        return players.get(playerId);
    }

    @Override
    public List<Player> getAllPlayers() {
        return new ArrayList<>(players.values());
    }
}
