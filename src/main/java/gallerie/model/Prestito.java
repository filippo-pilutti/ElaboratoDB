package gallerie.model;

import java.util.Date;
import java.util.Objects;

public class Prestito {
	private final int codArtista;
	private final String titoloOpera;
	private final int codMuseo;
	private final Date dataInizio;
	private final Date dataFine;
	
	public Prestito(final int codArtista, final String titoloOpera, final int codMuseo, final Date dataInizio, 
					final Date dataFine) {
		this.codArtista = codArtista;
		this.titoloOpera = Objects.requireNonNull(titoloOpera);
		this.codMuseo = codMuseo;
		this.dataInizio = Objects.requireNonNull(dataInizio);
		this.dataFine = Objects.requireNonNull(dataFine);
	}

	public int getCodArtista() {
		return codArtista;
	}

	public String getTitoloOpera() {
		return titoloOpera;
	}

	public int getCodMuseo() {
		return codMuseo;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codArtista, titoloOpera, codMuseo, dataInizio, dataFine);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestito other = (Prestito) obj;
		if (codArtista != other.codArtista)
			return false;
		if (codMuseo != other.codMuseo)
			return false;
		if (dataFine == null) {
			if (other.dataFine != null)
				return false;
		} else if (!dataFine.equals(other.dataFine))
			return false;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (titoloOpera == null) {
			if (other.titoloOpera != null)
				return false;
		} else if (!titoloOpera.equals(other.titoloOpera))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prestito [codArtista=" + codArtista + ", titoloOpera=" + titoloOpera + ", codMuseo=" + codMuseo
				+ ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + "]";
	}
	
	

}
