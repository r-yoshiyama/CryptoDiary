package util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtil {

	public static String[] readFile(String name) {
		Path path = Paths.get(name);
		String[] strs = new String[1];
		System.out.println(path.getParent().toString()+ "\n" + path.toString());
		System.out.println(Files.exists(path));
		if(!Files.exists(path)) {
			strs[0] = "";
			try {
				Files.createDirectories(path.getParent());
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Files.createFile(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			try {
				List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
				strs = list.toArray(new String[list.size()]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return strs;

	}

	public static void writeFile(String name, String[] strs, boolean flag) {
		Path path = Paths.get(name);
		System.out.println(path.getParent().toString()+ "\n" + path.toString());
		System.out.println(Files.exists(path));
		if(!Files.exists(path)) {
			try {
				Files.createDirectories(path.getParent());
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			Files.write(path, String.join("\n", strs).getBytes(StandardCharsets.UTF_8.name()), flag ? StandardOpenOption.APPEND : StandardOpenOption.TRUNCATE_EXISTING);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
