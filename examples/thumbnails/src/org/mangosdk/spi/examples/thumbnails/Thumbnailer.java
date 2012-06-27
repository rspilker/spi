/*

Copyright 2008 TOPdesk, the Netherlands

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

*/

package org.mangosdk.spi.examples.thumbnails;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

import javax.imageio.ImageIO;

import org.mangosdk.spi.examples.thumbnails.spi.ThumbnailRenderer;

public class Thumbnailer {
	
	public static void main(String... args) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage: java -cp <classpath_containing_implementations_of_renderers> Thumbnailer <file_1> [<file_2>...<file_n>]");
			return;
		}
		for (String name : args) {
			renderThumbNail(name);
		}
	}

	private static void renderThumbNail(String name) {
		File file = new File(name);
		if (!file.exists()) {
			System.out.println("Cannot find file '" + name + "'");
			return;
		}
		if (!file.canRead()) {
			System.out.println("Cannot read file '" + name + "'");
			return;
		}
		
		ThumbnailRenderer renderer = findRenderer(file);
		if (renderer == null) {
			System.out.println("Cannot find suitable renderer for '" + name + "'");
			return;
		}
		
		RenderedImage thumbnail;
		try {
			System.out.println("Using renderer '" + renderer.getDescription() + "' for '" + name + "'");
			thumbnail = renderer.render(file);
		}
		catch (Exception e) {
			System.err.println("Error while rendering thumbnail for '" + name + "' using renderer " + renderer.getDescription() + ": " + e.getMessage());
			return;
		}
		writeImage(name, thumbnail);
		
	}
	
	private static void writeImage(String name, RenderedImage thumbnail) {
		String fileName = name + "-thumb.png";
		try {
			FileOutputStream out = new FileOutputStream(fileName);
			try {
				ImageIO.write(thumbnail, "png", out);
				System.out.println("Successfully created '" + fileName + "' for '" + name + "'");
			}
			finally {
				out.close();
			}
		} 
		catch (IOException e) {
			System.err.println("Error while writing '" + fileName + "'");
		}
	}

	private static ThumbnailRenderer findRenderer(File file) {
		Iterator<ThumbnailRenderer> renderers = ServiceLoader.load(ThumbnailRenderer.class).iterator();
		while (renderers.hasNext()) {
			try {
				ThumbnailRenderer renderer = renderers.next();
				if (renderer.accepts(file)) {
					return renderer;
				}
			}
			catch (ServiceConfigurationError e){
				// For now just ignore the exceptions
			}
		}
		return null;
	}
}
