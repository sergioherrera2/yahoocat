package com.sherrerap.yahoocat.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.NoArgsConstructor;

@XmlRootElement
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
	private String vot_date;
	private String lastanswerts;
	private String qlang;
	private String qintl;
	private String language;
	private String id;
	private String best_id;

	public Document(String uri, String subject, String content, String bestanswer, List<String> nbestanswers,
			String cat, String maincat, String subcat, String date, String res_date, String vot_date,
			String lastanswerts, String qlang, String qintl, String language, String id, String best_id) {
		super();
		this.uri = uri;
		this.subject = subject;
		this.content = content;
		this.bestanswer = bestanswer;
		this.nbestanswers = nbestanswers;
		this.cat = cat;
		this.maincat = maincat;
		this.subcat = subcat;
		this.date = date;
		this.res_date = res_date;
		this.vot_date = vot_date;
		this.lastanswerts = lastanswerts;
		this.qlang = qlang;
		this.qintl = qintl;
		this.language = language;
		this.id = id;
		this.best_id = best_id;
	}

	public Document() {
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@XmlAttribute
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@XmlAttribute
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@XmlAttribute
	public String getBestanswer() {
		return bestanswer;
	}

	public void setBestanswer(String bestanswer) {
		this.bestanswer = bestanswer;
	}

	@XmlAttribute
	public List<String> getNbestanswers() {
		return nbestanswers;
	}

	public void setNbestanswers(List<String> nbestanswers) {
		this.nbestanswers = nbestanswers;
	}

	@XmlAttribute
	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	@XmlAttribute
	public String getMaincat() {
		return maincat;
	}

	public void setMaincat(String maincat) {
		this.maincat = maincat;
	}

	@XmlAttribute
	public String getSubcat() {
		return subcat;
	}

	public void setSubcat(String subcat) {
		this.subcat = subcat;
	}

	@XmlAttribute
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@XmlAttribute
	public String getRes_date() {
		return res_date;
	}

	public void setRes_date(String vot_date) {
		this.vot_date = vot_date;
	}

	@XmlAttribute
	public String getVot_date() {
		return vot_date;
	}

	public void setVot_date(String res_date) {
		this.res_date = res_date;
	}

	@XmlAttribute
	public String getLastanswerts() {
		return lastanswerts;
	}

	public void setLastanswerts(String lastanswerts) {
		this.lastanswerts = lastanswerts;
	}

	@XmlAttribute
	public String getQlang() {
		return qlang;
	}

	public void setQlang(String qlang) {
		this.qlang = qlang;
	}

	@XmlAttribute
	public String getQintl() {
		return qintl;
	}

	public void setQintl(String qintl) {
		this.qintl = qintl;
	}

	@XmlAttribute
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlAttribute
	public String getBest_id() {
		return best_id;
	}

	public void setBest_id(String best_id) {
		this.best_id = best_id;
	}

}
