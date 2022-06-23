package gallerie.model;

import java.util.Objects;
import java.util.Optional;

public class Opera {
	private final int codArtista;
	private final String titolo;
	private final long valore;
	private final int annoRealizzazione;
	private final int codTipo;
	private final Optional<Integer> codGalleria;
	
	public Opera(final int codArtista, final String titolo, final long valore, final int annoRealizzazione, final int codTipo,
					Optional<Integer> codGalleria) {
		this.codArtista = codArtista;
		this.titolo = Objects.requireNonNull(titolo);
		this.valore = valore;
		this.annoRealizzazione = annoRealizzazione;
		this.codTipo = codTipo;
		this.codGalleria = Objects.requireNonNull(codGalleria);
	}

	public Optional<Integer> getCodGalleria() {
		return codGalleria;
	}

	public int getCodArtista() {
		return codArtista;
	}

	public String getTitolo() {
		return titolo;
	}

	public long getValore() {
		return valore;
	}

	public int getAnnoRealizzazione() {
		return annoRealizzazione;
	}

	public int getCodTipo() {
		return codTipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codArtista, titolo, valore, annoRealizzazione, codTipo, codGalleria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Opera other = (Opera) obj;
		if (annoRealizzazione != other.annoRealizzazione)
			return false;
		if (codArtista != other.codArtista)
			return false;
		if (codGalleria == null) {
			if (other.codGalleria != null)
				return false;
		} else if (!codGalleria.equals(other.codGalleria))
			return false;
		if (codTipo != other.codTipo)
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		if (valore != other.valore)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Opera [codArtista=" + codArtista + ", titolo=" + titolo + ", valore=" + valore + ", annoRealizzazione="
				+ annoRealizzazione + ", codTipo=" + codTipo + ", codGalleria=" + codGalleria + "]";
	}
	
	
	

}
