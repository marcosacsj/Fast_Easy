/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appadm;

/**
 *
 * @author Notebook
 */
public class Parametros {
    private static String sNmUsuas;
    private static String sSenhaUsuas;
    
    public static String getsNmUsuas()
    {
        return sNmUsuas;
    }
    public static void setsNmUsuas(String aNmUsuas)
    {
       Parametros.sNmUsuas=aNmUsuas;
      
    }
    
    public static String getsSenhaUsuas()
    {
        return sSenhaUsuas;
    }
    public static void setsSenhaUsuas(String aSenhaUsuas)
    {
       Parametros.sSenhaUsuas=aSenhaUsuas;
      
    }
}
