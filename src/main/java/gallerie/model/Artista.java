package gallerie.model;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class Artista {
	private final Optional<String> nome;
	private final Optional<String> cognome;
	private final Optional<String> nomeArte;
	private final Optional<Long> telefono;
	private final Optional<String> mail;
	private final Optional<Date> dataMorte;
	private final int codArtista;
	
	public Artista(final Optional<String> nome, final Optional<String> cognome, final Optional<String> nomeArte,
					final Optional<Long> telefono, final Optional<String> mail, final Optional<Date> dataMorte,
					final int codArtista) {
		this.nome = Objects.requireNonNull(nome);
		this.cognome = Objects.requireNonNull(cognome);
		this.nomeArte = Objects.requireNonNull(nomeArte);
		this.telefono = Objects.requireNonNull(telefono);
		this.mail = Objects.requireNonNull(mail);
		this.dataMorte = Objects.requireNonNull(dataMorte);
		this.codArtista = codArtista;
	}
	
	public Artista(final Optional<String> nome, final Optional<String> cognome, final Optional<Date> dataMorte,
					final int codArtista) {
		this(nome, cognome, Optional.empty(), Optional.empty(), Optional.empty(), dataMorte, codArtista);
	}
	
	public Artista(final Optional<String> nome, final Optional<String> cognome, final Optional<Long> telefono, 
					final Optional<String> mail, final int codArtista) {
		this(nome, cognome, Optional.empty(), telefono, mail, Optional.empty(), codArtista);
	}
	
	public Optional<String> getNome() {
		return nome;
	}

	public Optional<String> getCognome() {
		return cognome;
	}

	public Optional<String> getNomeArte() {
		return nomeArte;
	}

	public Optional<Long> getTelefono() {
		return telefono;
	}

	public Optional<String> getMail() {
		return mail;
	}

	public Optional<Date> getDataMorte() {
		return dataMorte;
	}

	public int getCodArtista() {
		return codArtista;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, cognome, nomeArte, telefono, mail, dataMorte, codArtista);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		if (codArtista != other.codArtista)
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataMorte == null) {
			if (other.dataMorte != null)
				return false;
		} else if (!dataMorte.equals(other.dataMorte))
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
		if (nomeArte == null) {
			if (other.nomeArte != null)
				return false;
		} else if (!nomeArte.equals(other.nomeArte))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artista [nome=" + nome.orElse("null") + ", cognome=" + cognome.orElse("null")
				+ ", nomeArte=" + nomeArte.orElse("null") + ", telefono=" + (telefono.isPresent() ? telefono.get() : "null")
				+ ", mail=" + mail.orElse("null") + ", dataMorte=" + (dataMorte.isPresent() ? dataMorte.get() : "null")
				+ ", codArtista=" + codArtista + "]";
	}
	
}
