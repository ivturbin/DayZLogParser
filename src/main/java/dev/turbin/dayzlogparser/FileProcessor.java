package dev.turbin.dayzlogparser;

import dev.turbin.dayzlogparser.model.ActionType;
import dev.turbin.dayzlogparser.model.PlayerLog;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FileProcessor {

    static Path path;

    static Map<String, PlayerLog> getEveryPlayerLastLog(Path dir) {

        path = dir;
        Map<String, PlayerLog> map = new HashMap<>();

        try (Stream<Path> paths = Files.list(dir)) {

            paths.filter(Files::isRegularFile)
                    .forEach(path -> {
                        try (Stream<String> lines = Files.lines(path)) {

                            lines.map(Parser::parse)
                                    .filter(log -> log instanceof PlayerLog)
                                    .map(log -> (PlayerLog) log)
                                    .filter(playerLog -> playerLog.getActionType() != ActionType.disconnected)
                                    .forEach(playerLog -> map.put(playerLog.getId(), playerLog));

                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    static List<PlayerLog> getPlayerLogs(String id) {
        List<PlayerLog> logs = new ArrayList<>();

        try (Stream<Path> paths = Files.list(path)) {

            paths.filter(Files::isRegularFile)
                    .forEach(path -> {
                        try (Stream<String> lines = Files.lines(path)) {

                            lines.map(Parser::parse)
                                    .filter(log -> log instanceof PlayerLog)
                                    .map(log -> (PlayerLog) log)
                                    .filter(playerLog -> playerLog.getId().equals(id))
                                    .forEach(logs::add);

                        } catch (IOException e) {
                            throw new UncheckedIOException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return logs;
    }

}