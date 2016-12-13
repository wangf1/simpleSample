package com.wangf.io.file;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.input.Tailer;
import org.apache.commons.io.input.TailerListenerAdapter;

import com.google.common.io.Files;

public class CommonsIOExample {

	public static final String TAILER_STOP_INDICATOR = "END OF FILE";

	public static void main(String[] args) throws IOException {
		CommonsIOExample example = new CommonsIOExample();
		example.startTailer();

	}

	public void startTailer() throws IOException {
		URL inputStream = getClass().getResource("file.txt");
		File file = new File(inputStream.getFile());
		String allContent = Files.toString(file, StandardCharsets.UTF_8);
		System.out.println("All Content:" + allContent);
		MyTailerListener listener = new MyTailerListener();
		Tailer tailer = new Tailer(file, listener, 1000);
		Thread thread = new Thread(tailer);
		thread.start();
	}

	public static class MyTailerListener extends TailerListenerAdapter {
		private Tailer tailer;

		@Override
		public void handle(String line) {
			System.out.println(line);
			if (TAILER_STOP_INDICATOR.equals(line)) {
				tailer.stop();
			}
		}

		@Override
		public void fileRotated() {
		}

		@Override
		public void init(Tailer tailer) {
			super.init(tailer);
			this.tailer = tailer;
		}

	}
}
