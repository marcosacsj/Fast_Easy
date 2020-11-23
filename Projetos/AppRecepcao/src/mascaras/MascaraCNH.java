package mascaras;

import java.awt.Toolkit;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;



public class MascaraCNH extends PlainDocument 
{		
//	private static final long serialVersionUID = -7267161151016478559L;
	public static final int NUMERO_DIGITOS_MAXIMO = 14;
//	private int caracters = 0;
	

	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException
	{		
		///Toolkit.getDefaultToolkit().beep();				
		
		if (str.equals(null))
		{			
			return;
		}
		
		String texto = getText(0, getLength());     
		for (int i = 0; i < str.length(); i++) 
		{	char c = str.charAt(i);     
		    if (!Character.isDigit(c)) 
		    {	
		        return;     
		    }     
		 }
		 if(texto.length() < this.NUMERO_DIGITOS_MAXIMO)
		 {
			 super.remove(0, getLength());
			 
		    texto = texto.replace(".", "").replace(",", ""); 
                     texto = texto.replace(".", "");
		     StringBuffer s = new StringBuffer(texto + str);     
		     
		     if (s.length() > 0 && s.charAt(0) == '0') 
		    {     
		     s.deleteCharAt(0);     
		     }     
		     
		   if(s.length() < 3) 
		  {     
		 	 if (s.length() < 1) 
		   	 {     
		   	 s.insert(0,"000");     
		    }
		   	 else if (s.length() < 2) 
		  	 {     
		  		 s.insert(0,"00");     
		  	 }
		  	 else
		  	 {     
		  		 s.insert(0,"0");     
		  	 }     
		   }		     
		    s.insert(s.length()-3, ".");     
		   if(s.length() > 7) 
		   {     
		   	 s.insert(s.length()-7, ".");     
		    }
                     
		  //  if(s.length() > 6) 
		  //   {     
		  //  	 s.insert(s.length()-7, ".");     
		  //   }		     
		    if(s.length() > 11) 
		   {     
		  	 s.insert(s.length()-11, ".");     
		    }		     
		     super.insertString(0, s.toString(), attr);		     
//		     AppPdv.EscreveCaracterTeclado(2, 1, s.toString());
		     //AppPdv.EscreveTeclado(2, 1, s.toString());
		  }		
	}
	
	public void remove(int offset, int length) throws BadLocationException
	{		
		super.remove(offset, length);     
	    String texto = getText(0, getLength());     
	    texto = texto.replace(",", "");     
	    texto = texto.replace(".", "");     
	    super.remove(0, getLength());
	  //  AppPdv.LimpaLinhaTeclado(2);
	    //AppPdv.EscreveCaracterTeclado(2, 1, texto);
	    //insertString(0, texto, null);  
	    
}
}


