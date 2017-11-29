package library;

import javax.servlet.http.Part;

public class FileNameLibrary {
	public static String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				String clienFileName =  content.substring(content.indexOf('=') + 2, content.length() - 1)
						.replace("\\", "/");
				int i = clienFileName.lastIndexOf('/');
				return clienFileName.substring(i + 1);
			}
		}
		return null;
	}
}
