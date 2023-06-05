package com.example.ISA.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class QuestionsForDonnor {
	
	enum AnswerType{yes,no};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column
	//private Patient patient;
	
	@Column
	private String brojDavaoca;
	
	@Column
	private LocalDateTime datum;
	@Column
	private String prezimeRoditeljIme;
	@Column
	private String jmbg;
	@Column
	private String datumRodjenja;
	@Column
	private GenderType pol;
	@Column
	private String adresa;
	@Column
	private String opstina;
	@Column
	private String mesto;
	@Column
	private String kucniTel;
	@Column
	private String poslovniTel;
	@Column
	private String mobilniTel;
	@Column
	private String preduzeceFakultetSkola;
	@Column
	private String zanimanje;
	@Column
	private Long brojDavanja;
	@Column
	private String potpis;
	

	@Column
	private AnswerType q1;
	@Column
	private AnswerType q2;
	@Column
	private AnswerType q3;
	@Column
	private AnswerType q4;
	@Column
	private AnswerType q5;
	@Column
	private AnswerType q6;
	@Column
	private AnswerType q7;
	@Column
	private AnswerType q8;
	@Column
	private AnswerType q9;
	@Column
	private AnswerType q10;
	@Column
	private AnswerType q11;
	@Column
	private AnswerType q12;
	@Column
	private AnswerType q13;
	@Column
	private AnswerType q14;
	@Column
	private AnswerType q15;
	@Column
	private AnswerType q16;
	@Column
	private AnswerType q17;
	@Column
	private AnswerType q18;
	@Column
	private AnswerType q19;
	@Column
	private AnswerType q20_a;
	@Column
	private AnswerType q20_b;
	@Column
	private AnswerType q20_c;
	@Column
	private AnswerType q21;
	@Column
	private AnswerType q22_a;
	@Column
	private AnswerType q22_b;
	@Column
	private AnswerType q22_c;
	@Column
	private AnswerType q22_d;
	@Column
	private AnswerType q22_e;
	@Column
	private AnswerType q22_f;
	@Column
	private AnswerType q22_g;
	@Column
	private AnswerType q23_a;
	@Column
	private AnswerType q23_b;
	@Column
	private AnswerType q23_c;
	@Column
	private AnswerType q23_d;
	@Column
	private AnswerType q23_e;
	@Column
	private AnswerType q23_f;
	@Column	
	private AnswerType q24;
	@Column
	private AnswerType q25;
	@Column
	private AnswerType q26;
	
	
	public QuestionsForDonnor() {
		super();
	}


	public QuestionsForDonnor(Long id, String brojDavaoca, LocalDateTime datum, String prezimeRoditeljIme, String jmbg,
			String datumRodjenja, GenderType pol, String adresa, String opstina, String mesto, String kucniTel,
			String poslovniTel, String mobilniTel, String preduzeceFakultetSkola, String zanimanje, Long brojDavanja,
			String potpis, AnswerType q1, AnswerType q2, AnswerType q3, AnswerType q4, AnswerType q5, AnswerType q6,
			AnswerType q7, AnswerType q8, AnswerType q9, AnswerType q10, AnswerType q11, AnswerType q12, AnswerType q13,
			AnswerType q14, AnswerType q15, AnswerType q16, AnswerType q17, AnswerType q18, AnswerType q19,
			AnswerType q20_a, AnswerType q20_b, AnswerType q20_c, AnswerType q21, AnswerType q22_a, AnswerType q22_b,
			AnswerType q22_c, AnswerType q22_d, AnswerType q22_e, AnswerType q22_f, AnswerType q22_g, AnswerType q23_a,
			AnswerType q23_b, AnswerType q23_c, AnswerType q23_d, AnswerType q23_e, AnswerType q23_f, AnswerType q24,
			AnswerType q25, AnswerType q26) {
		super();
		this.id = id;
		this.brojDavaoca = brojDavaoca;
		this.datum = datum;
		this.prezimeRoditeljIme = prezimeRoditeljIme;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.pol = pol;
		this.adresa = adresa;
		this.opstina = opstina;
		this.mesto = mesto;
		this.kucniTel = kucniTel;
		this.poslovniTel = poslovniTel;
		this.mobilniTel = mobilniTel;
		this.preduzeceFakultetSkola = preduzeceFakultetSkola;
		this.zanimanje = zanimanje;
		this.brojDavanja = brojDavanja;
		this.potpis = potpis;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		this.q5 = q5;
		this.q6 = q6;
		this.q7 = q7;
		this.q8 = q8;
		this.q9 = q9;
		this.q10 = q10;
		this.q11 = q11;
		this.q12 = q12;
		this.q13 = q13;
		this.q14 = q14;
		this.q15 = q15;
		this.q16 = q16;
		this.q17 = q17;
		this.q18 = q18;
		this.q19 = q19;
		this.q20_a = q20_a;
		this.q20_b = q20_b;
		this.q20_c = q20_c;
		this.q21 = q21;
		this.q22_a = q22_a;
		this.q22_b = q22_b;
		this.q22_c = q22_c;
		this.q22_d = q22_d;
		this.q22_e = q22_e;
		this.q22_f = q22_f;
		this.q22_g = q22_g;
		this.q23_a = q23_a;
		this.q23_b = q23_b;
		this.q23_c = q23_c;
		this.q23_d = q23_d;
		this.q23_e = q23_e;
		this.q23_f = q23_f;
		this.q24 = q24;
		this.q25 = q25;
		this.q26 = q26;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getBrojDavaoca() {
		return brojDavaoca;
	}



	public void setBrojDavaoca(String brojDavaoca) {
		this.brojDavaoca = brojDavaoca;
	}



	public LocalDateTime getDatum() {
		return datum;
	}



	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}



	public String getPrezimeRoditeljIme() {
		return prezimeRoditeljIme;
	}



	public void setPrezimeRoditeljIme(String prezimeRoditeljIme) {
		this.prezimeRoditeljIme = prezimeRoditeljIme;
	}



	public String getJmbg() {
		return jmbg;
	}



	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}



	public String getDatumRodjenja() {
		return datumRodjenja;
	}



	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}



	public GenderType getPol() {
		return pol;
	}



	public void setPol(GenderType pol) {
		this.pol = pol;
	}



	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public String getOpstina() {
		return opstina;
	}



	public void setOpstina(String opstina) {
		this.opstina = opstina;
	}



	public String getMesto() {
		return mesto;
	}



	public void setMesto(String mesto) {
		this.mesto = mesto;
	}



	public String getKucniTel() {
		return kucniTel;
	}



	public void setKucniTel(String kucniTel) {
		this.kucniTel = kucniTel;
	}



	public String getPoslovniTel() {
		return poslovniTel;
	}



	public void setPoslovniTel(String poslovniTel) {
		this.poslovniTel = poslovniTel;
	}



	public String getMobilniTel() {
		return mobilniTel;
	}



	public void setMobilniTel(String mobilniTel) {
		this.mobilniTel = mobilniTel;
	}



	public String getPreduzeceFakultetSkola() {
		return preduzeceFakultetSkola;
	}



	public void setPreduzeceFakultetSkola(String preduzeceFakultetSkola) {
		this.preduzeceFakultetSkola = preduzeceFakultetSkola;
	}



	public String getZanimanje() {
		return zanimanje;
	}



	public void setZanimanje(String zanimanje) {
		this.zanimanje = zanimanje;
	}



	public Long getBrojDavanja() {
		return brojDavanja;
	}



	public void setBrojDavanja(Long brojDavanja) {
		this.brojDavanja = brojDavanja;
	}



	public String getPotpis() {
		return potpis;
	}



	public void setPotpis(String potpis) {
		this.potpis = potpis;
	}



	public AnswerType getQ1() {
		return q1;
	}



	public void setQ1(AnswerType q1) {
		this.q1 = q1;
	}



	public AnswerType getQ2() {
		return q2;
	}



	public void setQ2(AnswerType q2) {
		this.q2 = q2;
	}



	public AnswerType getQ3() {
		return q3;
	}



	public void setQ3(AnswerType q3) {
		this.q3 = q3;
	}



	public AnswerType getQ4() {
		return q4;
	}



	public void setQ4(AnswerType q4) {
		this.q4 = q4;
	}



	public AnswerType getQ5() {
		return q5;
	}



	public void setQ5(AnswerType q5) {
		this.q5 = q5;
	}



	public AnswerType getQ6() {
		return q6;
	}



	public void setQ6(AnswerType q6) {
		this.q6 = q6;
	}



	public AnswerType getQ7() {
		return q7;
	}



	public void setQ7(AnswerType q7) {
		this.q7 = q7;
	}



	public AnswerType getQ8() {
		return q8;
	}



	public void setQ8(AnswerType q8) {
		this.q8 = q8;
	}



	public AnswerType getQ9() {
		return q9;
	}



	public void setQ9(AnswerType q9) {
		this.q9 = q9;
	}



	public AnswerType getQ10() {
		return q10;
	}



	public void setQ10(AnswerType q10) {
		this.q10 = q10;
	}



	public AnswerType getQ11() {
		return q11;
	}



	public void setQ11(AnswerType q11) {
		this.q11 = q11;
	}



	public AnswerType getQ12() {
		return q12;
	}



	public void setQ12(AnswerType q12) {
		this.q12 = q12;
	}



	public AnswerType getQ13() {
		return q13;
	}



	public void setQ13(AnswerType q13) {
		this.q13 = q13;
	}



	public AnswerType getQ14() {
		return q14;
	}



	public void setQ14(AnswerType q14) {
		this.q14 = q14;
	}



	public AnswerType getQ15() {
		return q15;
	}



	public void setQ15(AnswerType q15) {
		this.q15 = q15;
	}



	public AnswerType getQ16() {
		return q16;
	}



	public void setQ16(AnswerType q16) {
		this.q16 = q16;
	}



	public AnswerType getQ17() {
		return q17;
	}



	public void setQ17(AnswerType q17) {
		this.q17 = q17;
	}



	public AnswerType getQ18() {
		return q18;
	}



	public void setQ18(AnswerType q18) {
		this.q18 = q18;
	}



	public AnswerType getQ19() {
		return q19;
	}



	public void setQ19(AnswerType q19) {
		this.q19 = q19;
	}



	public AnswerType getQ20_a() {
		return q20_a;
	}



	public void setQ20_a(AnswerType q20_a) {
		this.q20_a = q20_a;
	}



	public AnswerType getQ20_b() {
		return q20_b;
	}



	public void setQ20_b(AnswerType q20_b) {
		this.q20_b = q20_b;
	}



	public AnswerType getQ20_c() {
		return q20_c;
	}



	public void setQ20_c(AnswerType q20_c) {
		this.q20_c = q20_c;
	}



	public AnswerType getQ21() {
		return q21;
	}



	public void setQ21(AnswerType q21) {
		this.q21 = q21;
	}



	public AnswerType getQ22_a() {
		return q22_a;
	}



	public void setQ22_a(AnswerType q22_a) {
		this.q22_a = q22_a;
	}



	public AnswerType getQ22_b() {
		return q22_b;
	}



	public void setQ22_b(AnswerType q22_b) {
		this.q22_b = q22_b;
	}



	public AnswerType getQ22_c() {
		return q22_c;
	}



	public void setQ22_c(AnswerType q22_c) {
		this.q22_c = q22_c;
	}



	public AnswerType getQ22_d() {
		return q22_d;
	}



	public void setQ22_d(AnswerType q22_d) {
		this.q22_d = q22_d;
	}



	public AnswerType getQ22_e() {
		return q22_e;
	}



	public void setQ22_e(AnswerType q22_e) {
		this.q22_e = q22_e;
	}



	public AnswerType getQ22_f() {
		return q22_f;
	}



	public void setQ22_f(AnswerType q22_f) {
		this.q22_f = q22_f;
	}



	public AnswerType getQ22_g() {
		return q22_g;
	}



	public void setQ22_g(AnswerType q22_g) {
		this.q22_g = q22_g;
	}



	public AnswerType getQ23_a() {
		return q23_a;
	}



	public void setQ23_a(AnswerType q23_a) {
		this.q23_a = q23_a;
	}



	public AnswerType getQ23_b() {
		return q23_b;
	}



	public void setQ23_b(AnswerType q23_b) {
		this.q23_b = q23_b;
	}



	public AnswerType getQ23_c() {
		return q23_c;
	}



	public void setQ23_c(AnswerType q23_c) {
		this.q23_c = q23_c;
	}



	public AnswerType getQ23_d() {
		return q23_d;
	}



	public void setQ23_d(AnswerType q23_d) {
		this.q23_d = q23_d;
	}



	public AnswerType getQ23_e() {
		return q23_e;
	}



	public void setQ23_e(AnswerType q23_e) {
		this.q23_e = q23_e;
	}



	public AnswerType getQ23_f() {
		return q23_f;
	}



	public void setQ23_f(AnswerType q23_f) {
		this.q23_f = q23_f;
	}



	public AnswerType getQ24() {
		return q24;
	}



	public void setQ24(AnswerType q24) {
		this.q24 = q24;
	}



	public AnswerType getQ25() {
		return q25;
	}



	public void setQ25(AnswerType q25) {
		this.q25 = q25;
	}



	public AnswerType getQ26() {
		return q26;
	}



	public void setQ26(AnswerType q26) {
		this.q26 = q26;
	}

	
	
	
	
	
	
}
