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

package org.mangosdk.spi.examples.img_thumbnailer;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.imageio.ImageIO;

import org.mangosdk.spi.ProviderFor;
import org.mangosdk.spi.examples.thumbnails.spi.ThumbnailRenderer;

@ProviderFor(ThumbnailRenderer.class)
public class ImgThumbnailRenderer implements ThumbnailRenderer {

	private static final Set<String> SUPPORTED_FILE_TYPES = 
			new TreeSet<String>(String.CASE_INSENSITIVE_ORDER){{
				add("png");
				add("jpg");
				add("gif");
	}};
	
	@Override
	public String getDescription() {
		return "Renderer for ordinary image files";
	}
	
	@Override
	public boolean accepts(File file) {
		String fileName = file.getName();
		int lastDot = fileName.lastIndexOf(".");
		if (lastDot == -1) {
			return false;
		}
		return SUPPORTED_FILE_TYPES.contains(fileName.substring(lastDot + 1));
	}

	@Override
	public RenderedImage render(File file) throws IOException {
		if (!accepts(file)) {
			throw new IllegalArgumentException("Cannot handle " + file);
		}
		
		BufferedImage input = ImageIO.read(file);
		BufferedImage result = new BufferedImage(75, 100, BufferedImage.TYPE_INT_ARGB);
		AffineTransform transform = AffineTransform.getScaleInstance(75.0d/input.getWidth(), 100.0d/input.getHeight());
		result.createGraphics().drawRenderedImage(input, transform);
		return result;
	}
}
