package com.java8.clonetest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("serial")
public class WeeklyLogWithAttachment implements Serializable {
	private String name;
	private String date;
	private String content;
	private Attachment attachment;

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return (this.name);
	}

	public String getDate() {
		return (this.date);
	}

	public String getContent() {
		return (this.content);
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public WeeklyLogWithAttachment deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(this);

		ByteArrayInputStream input = new ByteArrayInputStream(out.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(input);
		return (WeeklyLogWithAttachment) ois.readObject();

	}
}
