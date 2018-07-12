package util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

	public static String[] readFile(String name) {
		Path path = Paths.get("./data/" + name);
		String[] strs = new String[1];
		if(Files.exists(path) && Files.isReadable(path)) {
			try {
				List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
				strs = list.toArray(new String[list.size()]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			strs[0] = "File doesn't exist or can't read";
			System.out.println(strs[0]);
		}

		return strs;

	}

	public static void writeFile(String name, String[] strs) {
		Path path = Paths.get("./data/" + name);
		if(!Files.exists(path)) {
			try {
				Files.write(path, String.join("\n", strs).getBytes(StandardCharsets.UTF_8.name()));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-genesrated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("File already exist.");
		}
	}

}
