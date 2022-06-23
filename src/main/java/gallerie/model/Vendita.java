package gallerie.model;

import java.util.Date;
import java.util.Objects;

public class Vendita {
	private final int codVendita;
	private final int codArtista;
	private final String titoloOpera;
	private final Date dataVendita;
	private final long importo;
	private final String modalitaPagamento;
	private final boolean confermaPagamento;
	private final String cliente;
	
	public Vendita(final int codVendita, final int codArtista, final String titoloOpera, final Date dataVendita, 
					final long importo, final String modalitaPagamento, final boolean confermaPagamento,
					final String cliente) {
		this.codVendita = codVendita;
		this.codArtista = codArtista;
		this.titoloOpera = Objects.requireNonNull(titoloOpera);
		this.dataVendita = Objects.requireNonNull(dataVendita);
		this.importo = importo;
		this.modalitaPagamento = Objects.requireNonNull(modalitaPagamento);
		this.confermaPagamento = confermaPagamento;
		this.cliente = Objects.requireNonNull(cliente);
	}

	public int getCodVendita() {
		return codVendita;
	}

	public int getCodArtista() {
		return codArtista;
	}

	public String getTitoloOpera() {
		return titoloOpera;
	}

	public Date getDataVendita() {
		return dataVendita;
	}

	public long getImporto() {
		return importo;
	}

	public String getModalitaPagamento() {
		return modalitaPagamento;
	}

	public boolean isConfermaPagamento() {
		return confermaPagamento;
	}

	public String getCliente() {
		return cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codVendita, codArtista, titoloOpera, dataVendita, importo, modalitaPagamento,
							confermaPagamento, cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendita other = (Vendita) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codArtista != other.codArtista)
			return false;
		if (codVendita != other.codVendita)
			return false;
		if (confermaPagamento != other.confermaPagamento)
			return false;
		if (dataVendita == null) {
			if (other.dataVendita != null)
				return false;
		} else if (!dataVendita.equals(other.dataVendita))
			return false;
		if (importo != other.importo)
			return false;
		if (modalitaPagamento == null) {
			if (other.modalitaPagamento != null)
				return false;
		} else if (!modalitaPagamento.equals(other.modalitaPagamento))
			return false;
		if (titoloOpera == null) {
			if (other.titoloOpera != null)
				return false;
		} else if (!titoloOpera.equals(other.titoloOpera))
			return false;
		return true;
	}
	
	

}
