/**
 * Universidad de La Laguna
 * 	ETSII 
 * 	Curso 3� de Ingieneria Inform�tica
 * 	Fecha: 4-05-2017
 * 	Juego de bolas de colores
 * @author: Alejandro Hernandez Padron
 *
 */
package juegoTiro;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Timer;


/**
 * Clase controlador de nuestro programa que gestiona 
 * todos los eventos necesarios para funcion el 
 * juego, contiene dos modelos y dos vistas
 * Nuestros sonidos de impacto y de fallo
 *
 */
public class Controlador  implements ActionListener, MouseMotionListener, MouseListener{
	private BolasModelo bolas;
	private TiroModelo tiro;
	private VistaJuego juego;
	private InfoPanel info;
	private int diametro;
	private Timer tm;
	private AudioClip pinpon;
	private AudioClip fail;

	/**
	 * Constructor de nuestra clase 
	 * Seteamos la vistas, el diametro de nuestras bolas
	 * los controladores de las vistas y nuestros archivos
	 * de audio
	 * @param juego
	 * @param info
	 * @param diametro
	 */
	public Controlador(VistaJuego juego, InfoPanel info, int diametro) {
		setInfo(info);
		setJuego(juego);
		getJuego().setControl(this);
		getInfo().setControl(this);

		this.diametro = diametro;
		tm = new Timer(5, new Next());
		pinpon = Applet.newAudioClip(getClass().getResource("sound/pinpon.wav"));
		fail = Applet.newAudioClip(getClass().getResource("sound/fail.wav"));
	}

	/**
	 * Seteamos el Modelo a partir del ancho de neustra ventana
	 * y el diametro de neustras bolsa 
	 */
	public void setModelo(){
		setBolas(new BolasModelo(juego.getWidth(), diametro, 4));
		setTiro(new TiroModelo(juego.getWidth(), juego.getHeight(), diametro));
		getJuego().setDiametro(diametro);
		paint();
	}

	/**
	 * Dibujamos nuestras bolas pasandole todo lo necesario
	 * a nuestro panel de dibujo Juego
	 */
	public void paint(){
		getJuego().setBolas(getBolas().getBolas());
		getJuego().setColorBola((getBolas().getColorBola()));
		getJuego().setDibBolas((getBolas().getDibBolas()));
		getJuego().setCentro(getTiro().getCentro());
		getJuego().setTiro((getTiro().getTiro()));
		getJuego().setColorCentro(getTiro().getColorCentro());
		getJuego().setColorTiro(getTiro().getColorTiro());
		getJuego().repaint();
	}

	/**
	 * Gestionamos la pulsacion del boton de informacion
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Info")
			getInfo().showinfo();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == 1){
			//System.out.println("boton izq");
			if(!tm.isRunning()){
				tm.start();
				getTiro().setNewBola();
			}
		}
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("Moved");
		if(!tm.isRunning()){
			getTiro().setAngulo(e.getX(), e.getY());
			getJuego().setAngulo(getTiro().getAngulo());
			paint();
		}
	}

	/**
	 * Avanza nuestra bola, la redibuja y en 
	 * de impacto muestra los sonidos y resetea el tiro 
	 */
	class Next implements ActionListener {
		int fin = 0;
		public void actionPerformed(ActionEvent e) {
			getTiro().next();
			paint();

			int c = getBolas().colisiona(getTiro().getTiro(), fin);
			if(c > 0){
				if(fin > 1){
					tm.stop();
					getTiro().reset();
					paint();

					fin = 0;
					if(c > 1)
						fail.play();
					else
						pinpon.play();

				}else	
					fin++;

			}else if(getTiro().isOut()){
				fail.play();
				tm.stop();
				getTiro().reset();
				paint();
				fin = 0;	
			}
		}
	}


	/**
	 * @return the bolas
	 */
	public BolasModelo getBolas() {
		return bolas;
	}

	/**
	 * @param bolas the bolas to set
	 */
	public void setBolas(BolasModelo bolas) {
		this.bolas = bolas;
	}

	/**
	 * @return the tiro
	 */
	public TiroModelo getTiro() {
		return tiro;
	}

	/**
	 * @param tiro the tiro to set
	 */
	public void setTiro(TiroModelo tiro) {
		this.tiro = tiro;
	}

	/**
	 * @return the juego
	 */
	public VistaJuego getJuego() {
		return juego;
	}

	/**
	 * @param juego the juego to set
	 */
	public void setJuego(VistaJuego juego) {
		this.juego = juego;
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//		System.out.println("Released");
	}

	@Override
	public void mouseDragged(MouseEvent e) {

	}


	/**
	 * @return the info
	 */
	public InfoPanel getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(InfoPanel info) {
		this.info = info;
	}

	/**
	 * @return the diametro
	 */
	public int getDiametro() {
		return diametro;
	}

	/**
	 * @param diametro the diametro to set
	 */
	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	/**
	 * @return the tm
	 */
	public Timer getTm() {
		return tm;
	}

	/**
	 * @param tm the tm to set
	 */
	public void setTm(Timer tm) {
		this.tm = tm;
	}

	/**
	 * @return the pinpon
	 */
	public AudioClip getPinpon() {
		return pinpon;
	}

	/**
	 * @param pinpon the pinpon to set
	 */
	public void setPinpon(AudioClip pinpon) {
		this.pinpon = pinpon;
	}

	/**
	 * @return the fail
	 */
	public AudioClip getFail() {
		return fail;
	}

	/**
	 * @param fail the fail to set
	 */
	public void setFail(AudioClip fail) {
		this.fail = fail;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//		System.out.println("clicked");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//		System.out.println("Entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//		System.out.println("Exited");
	}


}
