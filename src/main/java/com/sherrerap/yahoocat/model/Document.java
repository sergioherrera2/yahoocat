package com.sherrerap.yahoocat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
	private String uri;
	private String subject;
	private String content;
	private String bestanswer;
	private List<String> nbestanswers;
	private String cat;
	private String maincat;
	private String subcat;
	private String date;
	private String res_date;
	private String lastanswerts;
	private String qlang;
	private String qintl;
	private String language;
	private int id;
	private String best_id;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBestanswer() {
		return bestanswer;
	}

	public void setBestanswer(String bestanswer) {
		this.bestanswer = bestanswer;
	}

	public List<String> getNbestanswers() {
		return nbestanswers;
	}

	public void setNbestanswers(List<String> nbestanswers) {
		this.nbestanswers = nbestanswers;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public String getMaincat() {
		return maincat;
	}

	public void setMaincat(String maincat) {
		this.maincat = maincat;
	}

	public String getSubcat() {
		return subcat;
	}

	public void setSubcat(String subcat) {
		this.subcat = subcat;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRes_date() {
		return res_date;
	}

	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}

	public String getLastanswerts() {
		return lastanswerts;
	}

	public void setLastanswerts(String lastanswerts) {
		this.lastanswerts = lastanswerts;
	}

	public String getQlang() {
		return qlang;
	}

	public void setQlang(String qlang) {
		this.qlang = qlang;
	}

	public String getQintl() {
		return qintl;
	}

	public void setQintl(String qintl) {
		this.qintl = qintl;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBest_id() {
		return best_id;
	}

	public void setBest_id(String best_id) {
		this.best_id = best_id;
	}

}
