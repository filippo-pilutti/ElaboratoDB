package gallerie.model;

import java.util.Objects;

public class Responsabile {
	private final String codFiscale;
	private final String nome;
	private final String cognome;
	private final long telefono;
	private final String mail;
	
	public Responsabile(final String codFiscale, final String nome, final String cognome, final long telefono, 
						final String mail) {
		this.codFiscale = Objects.requireNonNull(codFiscale);
		this.nome = Objects.requireNonNull(nome);
		this.cognome = Objects.requireNonNull(cognome);
		this.telefono = telefono;
		this.mail = Objects.requireNonNull(mail);
	}

	public String getCodFiscale() {
		return codFiscale;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public long getTelefono() {
		return telefono;
	}

	public String getMail() {
		return mail;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codFiscale, nome, cognome, telefono, mail);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsabile other = (Responsabile) obj;
		if (codFiscale == null) {
			if (other.codFiscale != null)
				return false;
		} else if (!codFiscale.equals(other.codFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefono != other.telefono)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Responsabile [codFiscale=" + codFiscale + ", nome=" + nome + ", cognome=" + cognome + ", telefono="
				+ telefono + ", mail=" + mail + "]";
	}
	
	

}
