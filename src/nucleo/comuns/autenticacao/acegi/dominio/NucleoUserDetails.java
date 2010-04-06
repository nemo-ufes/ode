package nucleo.comuns.autenticacao.acegi.dominio;

import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import nucleo.comuns.persistencia.NucleoObjetoPersistenteImpl;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.UserDetails;


/**
 * Usu�rio do sistema.
 * 
 * @author Alexandre G. N. Coelho
 * 
 */
@Entity
public class NucleoUserDetails extends NucleoObjetoPersistenteImpl<Long, Long>
		implements UserDetails {

	private static final long serialVersionUID = -4938847876332160344L;

	private String username;

	private String password;

	private NucleoPessoa pessoa;

	private Set<NucleoGrantedAuthority> grantedAuthorities;

	@Transient
	public GrantedAuthority[] getAuthorities() {
		Set<NucleoGrantedAuthority> conjGrantedAuthorities = getGrantedAuthorities();
		GrantedAuthority[] vtrGrantedAuthorities = new NucleoGrantedAuthority[conjGrantedAuthorities
				.size()];
		Iterator<NucleoGrantedAuthority> itGrantedAuthorities = conjGrantedAuthorities
				.iterator();
		int i = 0;
		while (itGrantedAuthorities.hasNext()) {
			vtrGrantedAuthorities[i] = itGrantedAuthorities.next();
			i++;
		}

		return vtrGrantedAuthorities;
	}

	@Column(length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToOne
	public NucleoPessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(NucleoPessoa pessoa) {
		this.pessoa = pessoa;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<NucleoGrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public void setGrantedAuthorities(
			Set<NucleoGrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	@Transient
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Transient
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Altera os dados do NucleoUserDetails para os dados do NucleoUserDetails
	 * fonte.
	 * 
	 * @param fonte
	 *            NucleoUserDetails de onde os dados devem ser copiados.
	 */
	public void alterarDados(NucleoUserDetails fonte) {
		this.setUsername(fonte.getUsername());
		this.setPassword(fonte.getPassword());
		NucleoGrantedAuthority grantedAuthorityDestino = this
				.getGrantedAuthorities().iterator().next();
		NucleoGrantedAuthority grantedAuthorityFonte = fonte
				.getGrantedAuthorities().iterator().next();
		grantedAuthorityDestino.setAuthority(grantedAuthorityFonte
				.getAuthority());
	}
}
