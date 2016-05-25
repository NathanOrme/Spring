package com.qa.ims.util;

import java.net.URL;

import javax.swing.ImageIcon;

public class Resources {

	public static ImageIcon getImage(String resource) {
		return new ImageIcon(getResourceURL(resource));
	}

	private static URL getResourceURL(String path) {
		return Resources.class.getResource("/" + path);
	}

}
