/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExecutiveService.java
 *
 * Created on 19/06/2012, 08:59:47
 */
package appadm;

/**
 *
 * @author MC System Work's
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utilitarios.ConectaBanco;
import utilitarios.InOut;
import mascaras.MascaraData;
import mascaras.MascaraNumero;
import mascaras.MascaraValor;

public class ExecutiveService extends javax.swing.JFrame {

   

    
    
    ConectaBanco con;
   // MascaraNumero lMascaraData=new MascaraNumero();
    MascaraValor lMascaraValor=new MascaraValor();
    MascaraValor lMascaraValor1=new MascaraValor();
    MascaraValor lMascaraValor2=new MascaraValor();
    MascaraValor lMascaraValor3=new MascaraValor();
    MascaraValor lMascaraValor4=new MascaraValor();
    int lIdVoucher=0;
    String valorkmrod=null;
    String sNumVoucher = new String();
    String sCliente = new String();
    public String usuario = Parametros.getsNmUsuas();
   // String emb= new String();
    
    
    
    ResultSet lRes =null;
   
    /** Creates new form ExecutiveService */
    
    public ExecutiveService() {
        super("     EXECUTIVE SERVICE       ");
        //this.setUndecorated(true);
        this.setLocation(100,20);
        initComponents();
       // emb="3,50";
       // TX_Emb1.setText(emb);
        Usuario.setText(usuario);
       jButton1.setVisible(false);
       CalculaValor.setVisible(false);
       //ValorUnitario.setVisible(false);
      //   NovoFormulario.setVisible(false);
       // DataDia.setDocument(lMascaraData);
        TX_Emb1.setDocument(lMascaraValor);
        TX_Pedagio.setDocument(lMascaraValor1);
        TX_Estacionamento.setDocument(lMascaraValor2);
        ValorTotal_KM.setDocument(lMascaraValor3);
       // ValorUnitario.setDocument(lMascaraValor4);
        ValorUnitario.setVerifyInputWhenFocusTarget(false);
        //coluna1, dados1=modelo1 (Pesquisa cliente)
        //coluna2, dados2=modelo2 (Pesquisa Voucher)
        String[] colunas1 = new String[]{"Empresa","CNPJ","Usuário"};
        String[] colunas2 = new String[]{"Nº Voucher","Empresa","Usuário","Motorista","Dia","Mes","Ano"};
        String[] colunas3 = new String[]{"MOTORISTA","CNH","CARRO","STATUS"};
        String[][] dados1 = new String[][]{};
        String[][] dados2 = new String[][]{};
        String[][] dados3 = new String[][]{};
        DefaultTableModel modelo1= new DefaultTableModel(dados1, colunas1);
        DefaultTableModel modelo2= new DefaultTableModel(dados2, colunas2);
        DefaultTableModel modelo3= new DefaultTableModel(dados3, colunas3);
        TabPesqCliente.setModel(modelo1);
        TabPesqVoucher.setModel(modelo2);
        TabPesqMotorista.setModel(modelo3);
        
        Cancelamento.setSize(510, 150);
        Cancelamento.setLocationRelativeTo(null);
        
        
        
    }
   
    public void populaTabela1(ResultSet res) {
         DefaultTableModel modelo1 = (DefaultTableModel) TabPesqCliente.getModel();
       
        try {
        con=new ConectaBanco();
        String sSql=new String();
        sSql="Select EMPRESA,CNPJ,USUARIO from CADCLIENTE where USUARIO='"+PesquisaCliente.getText()+"';";
        con.conecta();
         if(!con.conecta())
        {
            InOut.MsgDeErro("AppAdm","Erro ao conectar");
            return;            
        }
        con.executaSelect(sSql);
        System.out.println(sSql);
        lRes = con.resultset;      
        
            modelo1.setRowCount(0);
            while (lRes.next()) {
                modelo1.addRow(new Object[]{
                            lRes.getString("EMPRESA"),
                            lRes.getString("CNPJ"),
                            //lRes.getString("ENDERECO"),
                            lRes.getString("USUARIO"),
                            });

            }
            TabPesqCliente.setModel(modelo1);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(PesquisaCliente, ex);
        }
        con.desconecta();
    }
    
    public void populaTabela2(ResultSet res) {
        DefaultTableModel modelo2 = (DefaultTableModel) TabPesqVoucher.getModel();
       
        try {
        con=new ConectaBanco();
        String sSql=new String();
        sSql="Select NUMEROVOUCHER,EMPRESA,USUARIO,MOTORISTA,DATADIA,DATAMES,DATAANO from Voucher where NumeroVoucher="+PesquisaVoucher.getText()+" ORDER BY NUMEROVOUCHER;";
        con.conecta();
         if(!con.conecta())
        {
            InOut.MsgDeErro("AppAdm","Erro ao conectar");
            return;            
        }
        con.executaSelect(sSql);
        System.out.println(sSql);
        lRes = con.resultset;      
        
            modelo2.setRowCount(0);
            while (lRes.next()) {
                modelo2.addRow(new Object[]{
                            lRes.getString("NumeroVoucher"),
                            lRes.getString("Empresa"),
                            lRes.getString("Usuario"),
                            lRes.getString("Motorista"),
                            lRes.getString("DATADIA"),
                            lRes.getString("DATAMES"),
                            lRes.getString("DATAANO")});

            }
            TabPesqVoucher.setModel(modelo2);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(PesquisaVoucher, ex);
        }
        con.desconecta();
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cancelamento = new javax.swing.JFrame();
        CancelaVoucher = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        CancelaNumVoucher = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Empresa1 = new javax.swing.JTextField();
        Cliente1 = new javax.swing.JTextField();
        Origem1 = new javax.swing.JTextField();
        Area1 = new javax.swing.JTextField();
        SaidaHora1 = new javax.swing.JTextField();
        TX_Emb1 = new javax.swing.JTextField();
        Valor_Total = new javax.swing.JTextField();
        Motorista = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Tel1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        Destino1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        C_Custo1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        KM_Inicial1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ChegadaHora1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        KM_Final1 = new javax.swing.JTextField();
        KM_Rod1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TX_Pedagio = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TX_Parado = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TX_Estacionamento = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        PlacaCarro = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Salva1 = new javax.swing.JButton();
        Atualiza = new javax.swing.JButton();
        Fecha1 = new javax.swing.JButton();
        CadCliente1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Number = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        CalculaValor = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabPesqCliente = new javax.swing.JTable();
        PesquisaCliente = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabPesqVoucher = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        PesquisaVoucher = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabPesqMotorista = new javax.swing.JTable();
        PesMot = new javax.swing.JButton();
        PesquisaMotorista = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        NovoFormulario = new javax.swing.JButton();
        CalculaKM = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        ValorUnitario = new javax.swing.JTextField();
        ValorTotal_KM = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        DataMes = new javax.swing.JComboBox();
        Usuario = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        DataDia1 = new javax.swing.JComboBox();
        DataAno1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        CancelaVoucher.setBackground(new java.awt.Color(255, 255, 255));
        CancelaVoucher.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cancelamento de Voucher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Georgia", 3, 24))); // NOI18N
        CancelaVoucher.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 51, 0));
        jLabel29.setText("Numero do Voucher a ser cancelado :");

        CancelaNumVoucher.setBackground(new java.awt.Color(236, 233, 216));
        CancelaNumVoucher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CancelaNumVoucher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 51)));

        jButton5.setText("Confirmar");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });

        jButton6.setText("Fechar");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton6MousePressed(evt);
            }
        });

        javax.swing.GroupLayout CancelaVoucherLayout = new javax.swing.GroupLayout(CancelaVoucher);
        CancelaVoucher.setLayout(CancelaVoucherLayout);
        CancelaVoucherLayout.setHorizontalGroup(
            CancelaVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CancelaVoucherLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CancelaVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CancelaVoucherLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelaNumVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 84, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CancelaVoucherLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addContainerGap())
        );
        CancelaVoucherLayout.setVerticalGroup(
            CancelaVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CancelaVoucherLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(CancelaVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(CancelaNumVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(CancelaVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)))
        );

        javax.swing.GroupLayout CancelamentoLayout = new javax.swing.GroupLayout(Cancelamento.getContentPane());
        Cancelamento.getContentPane().setLayout(CancelamentoLayout);
        CancelamentoLayout.setHorizontalGroup(
            CancelamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CancelamentoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CancelaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CancelamentoLayout.setVerticalGroup(
            CancelamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CancelaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(44, 52, 75));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Logo4.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("EMPRESA :");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOME COMPLETO DO USUÁRIO :");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ORIGEM :");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ÁREA :");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SAÍDA (HORAS):");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TX EMBARQUE:");

        jLabel8.setFont(new java.awt.Font("Georgia", 3, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("VALOR TOTAL :");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("MOTORISTA :");

        Empresa1.setBackground(new java.awt.Color(204, 204, 204));
        Empresa1.setEditable(false);

        Cliente1.setBackground(new java.awt.Color(204, 204, 204));
        Cliente1.setEditable(false);

        Valor_Total.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TELEFONE / RAMAL :");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DESTINO :");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("C. DE CUSTO :");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("KM :");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CHEGADA (HORAS):");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("KM :");

        KM_Rod1.setBackground(new java.awt.Color(204, 204, 204));
        KM_Rod1.setEditable(false);
        KM_Rod1.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("PEDÁGIO :");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("HORA PARADA :");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("ESTACIONAMENTO :");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("PLACA :");

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("DATA :");

        Salva1.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        Salva1.setText("SALVAR");
        Salva1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Salva1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Salva1MousePressed(evt);
            }
        });

        Atualiza.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        Atualiza.setText("ATUALIZAR");
        Atualiza.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Atualiza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AtualizaMousePressed(evt);
            }
        });

        Fecha1.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        Fecha1.setText("FECHAR");
        Fecha1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Fecha1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Fecha1MousePressed(evt);
            }
        });

        CadCliente1.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        CadCliente1.setText("CADASTRAR");
        CadCliente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CadCliente1MousePressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Georgia", 3, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Executive Service");

        jLabel26.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Nº :");

        Number.setBackground(new java.awt.Color(204, 204, 204));

        CalculaValor.setText("CALCULAR");
        CalculaValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CalculaValorMousePressed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(44, 52, 75));

        TabPesqCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabPesqCliente.getTableHeader().setReorderingAllowed(false);
        TabPesqCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabPesqClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabPesqCliente);
        TabPesqCliente.getColumnModel().getColumn(0).setResizable(false);
        TabPesqCliente.getColumnModel().getColumn(1).setResizable(false);
        TabPesqCliente.getColumnModel().getColumn(3).setResizable(false);

        jButton2.setText("PESQUISAR");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("DIGITE O NOME DO CLIENTE :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 229, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PesquisaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel24))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLIENTE", jPanel3);

        jPanel2.setBackground(new java.awt.Color(44, 52, 75));

        TabPesqVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabPesqVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabPesqVoucherMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabPesqVoucher);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("DIGITE O Nº DO VOUCHER :");

        jButton3.setText("PESQUISAR");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PesquisaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(0, 423, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(PesquisaVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("VOUCHER", jPanel2);

        jPanel4.setBackground(new java.awt.Color(44, 52, 75));

        TabPesqMotorista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabPesqMotorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabPesqMotoristaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TabPesqMotorista);

        PesMot.setText("PESQUISAR");
        PesMot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PesMotMousePressed(evt);
            }
        });
        PesMot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesMotActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("DIGITE O NOME DO MOTORISTA :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PesquisaMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(PesMot)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(PesquisaMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PesMot))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MOTORISTA", jPanel4);

        NovoFormulario.setFont(new java.awt.Font("Georgia", 0, 11)); // NOI18N
        NovoFormulario.setText("LIMPAR");
        NovoFormulario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NovoFormulario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NovoFormularioMousePressed(evt);
            }
        });

        CalculaKM.setText("KM ROD");
        CalculaKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CalculaKMMousePressed(evt);
            }
        });

        jButton1.setText("VALOR TOTAL KM");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        ValorUnitario.setBackground(new java.awt.Color(204, 204, 204));
        ValorUnitario.setEditable(false);

        ValorTotal_KM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorTotal_KMActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("VALOR KM RODADO :");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("VALOR POR KM:");

        DataMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "JANEIRO", "FEVEREIRO", "MARCO", "ABRIL", "MAIO", "JUNHO", "JULHO", "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO" }));

        Usuario.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        Usuario.setForeground(new java.awt.Color(153, 255, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 255, 255));
        jLabel28.setText("OPERADOR:");

        DataDia1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        DataAno1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));

        jButton4.setText("OUTROS");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Motorista)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(PlacaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DataDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DataMes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DataAno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(17, 17, 17))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TX_Emb1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel17))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TX_Pedagio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TX_Parado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel19)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TX_Estacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(88, 88, 88)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(Valor_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jButton1)
                                            .addGap(18, 18, 18)
                                            .addComponent(CalculaValor))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel16)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ValorTotal_KM, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SaidaHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(KM_Inicial1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ChegadaHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(KM_Final1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CalculaKM)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(KM_Rod1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator5, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                                .addComponent(jSeparator4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Empresa1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Tel1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addGap(120, 120, 120))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Area1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Origem1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C_Custo1))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Destino1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Number, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CadCliente1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NovoFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Salva1)
                .addGap(18, 18, 18)
                .addComponent(Atualiza)
                .addGap(18, 18, 18)
                .addComponent(Fecha1)
                .addGap(53, 53, 53))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TX_Emb1, TX_Estacionamento, TX_Parado, TX_Pedagio});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(11, 11, 11))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Empresa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(Tel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(Cliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Origem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(Destino1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Area1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(C_Custo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaidaHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(KM_Inicial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(ChegadaHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(KM_Final1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KM_Rod1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(CalculaKM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TX_Emb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(TX_Pedagio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(TX_Parado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(TX_Estacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(ValorTotal_KM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel8)
                    .addComponent(ValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Valor_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(CalculaValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Motorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(PlacaCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(DataDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DataAno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CadCliente1)
                    .addComponent(Salva1)
                    .addComponent(Atualiza)
                    .addComponent(Fecha1)
                    .addComponent(NovoFormulario)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void Fecha1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Fecha1MousePressed
//InicialTela abrir=new InicialTela();
//abrir.setVisible(true);
this.dispose();
}//GEN-LAST:event_Fecha1MousePressed

private void CadCliente1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadCliente1MousePressed
CadastroCliente abrir=new CadastroCliente();
abrir.setVisible(true);
this.dispose();
}//GEN-LAST:event_CadCliente1MousePressed

    private void Salva1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salva1MousePressed
        // TODO add your handling code here:
        int verifica=0;
        verifica=InOut.MsgDeSimNao("Salvamento", "As informações estão corretas?");
        switch(verifica){
            case 0:
                 String sSql = new String();
                 sSql = "Insert into Voucher (NumeroVoucher,Empresa,Telefone,Usuario,Origem,Destino,Area,Ccusto,Hsaida,Kmsaida,Hchegada,Kmchegada,Kmfinal,Txembarque,Pedagio,Horaparada,Estacionamento,Valorkm,ValorTotal,Motorista,Placa,DataDia,DataMes,DataAno,operador) Values"
                            + "('"+Number.getText()+"','"+Empresa1.getText()+"','"+Tel1.getText()+"','"+Cliente1.getText()+"','"+Origem1.getText()+"','"+Destino1.getText()+"','"+Area1.getText()+"','"+C_Custo1.getText()+"','"+SaidaHora1.getText()+"','"+KM_Inicial1.getText()+"','"+ChegadaHora1.getText()+"','"+KM_Final1.getText()+"','"+KM_Rod1.getText()+"','"+TX_Emb1.getText()+
                             "','"+TX_Pedagio.getText()+"','"+TX_Parado.getText()+"','"+TX_Estacionamento.getText()+"','"+ValorTotal_KM.getText()+"','"+Valor_Total.getText()+"','"+Motorista.getText()+"','"+PlacaCarro.getText()+"','"+DataDia1.getSelectedItem()+"','"+DataMes.getSelectedItem()+"','"
                            +DataAno1.getSelectedItem()+"','"+Usuario.getText()+"');"; 
                con= new ConectaBanco();
                if(!con.conecta())
                {
                     InOut.MsgDeErro("AppAdm","Erro ao conectar");
                     return;            
                }
                con.executa(sSql);          
                con.desconecta();
                this.LimpaCampos();
                break;
        }
        
        
        
       
        
    }//GEN-LAST:event_Salva1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        TabPesqCliente.setVisible(true);
        con=new ConectaBanco();
        String sSql=new String();
        sSql="Select EMPRESA,ENDERECO,TELEFONE,USUARIO from CADCLIENTE where empresa='"+PesquisaCliente.getText()+"'ORDER BY USUARIO;";
        con.conecta();
        con.executaSelect(sSql);
       // System.out.println(sSql);
        populaTabela1(con.resultset);
        con.desconecta();
        //Integer.parseInt("Aqui é a string");
        //Double calculo = Double.parseDouble("Aqui e a string");
        //controle.settext(String.valueOf(calculo).replace('.', ','))
        
        
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
        
        TabPesqCliente.setVisible(true);
        TabPesqVoucher.setVisible(true);
         con=new ConectaBanco();
        String sSql=new String();
         sSql="Select NUMEROVOUCHER,EMPRESA,USUARIO,MOTORISTA,DATADIA,DATAMES,DATAANO from Voucher where NumeroVoucher="+PesquisaVoucher.getText()+" ORDER BY NUMEROVOUCHER;";
        con.conecta();
        con.executaSelect(sSql);
        System.out.println(sSql);
        populaTabela2(con.resultset);
        con.desconecta();
        
    }//GEN-LAST:event_jButton3MousePressed

private void TabPesqClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabPesqClienteMouseClicked
// TODO add your handling code here:
    //InOut.MsgDeAviso("teste", "cliquei");
    int linha=0;
    
   // int coluna=0;
    
    TabPesqCliente.setVisible(true);
    linha=TabPesqCliente.getSelectedRow();
    //Empresa1.setText(TabPesqCliente.getValueAt(linha, coluna).toString());
    String sCliente1 = new String();
    sCliente = TabPesqCliente.getValueAt(linha, 2).toString();
    sCliente1=TabPesqCliente.getValueAt(linha, 0).toString();
    System.out.println(sCliente);
        con=new ConectaBanco();
        String sSql=new String();
        sSql="Select EMPRESA,USUARIO,VALORKM from cadcliente where empresa='"+sCliente1+"'and usuario='"+sCliente+"'ORDER BY USUARIO;";
        con.conecta();
         if(!con.conecta())
        {
            InOut.MsgDeErro("AppAdm","Erro ao conectar");
            return;            
        }
        con.executaSelect(sSql);
        
        lRes=con.resultset;        
        try 
        {           
            while (lRes.next())
            {
                
                 Empresa1.setText(lRes.getString("Empresa"));              
                 Cliente1.setText(lRes.getString("Usuario"));
                 ValorUnitario.setText(lRes.getString("VALORKM"));
               
                                               
            }            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ExecutiveService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.desconecta();
    
}//GEN-LAST:event_TabPesqClienteMouseClicked

private void TabPesqVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabPesqVoucherMouseClicked
// TODO add your handling code here:
    //InOut.MsgDeAviso("teste", "cliquei");
    
    Salva1.setVisible(false);
    NovoFormulario.setVisible(true);
    int linha=0;
    
    
    
    linha = TabPesqVoucher.getSelectedRow();
    sNumVoucher = TabPesqVoucher.getValueAt(linha, 0).toString();
    System.out.println(sNumVoucher);
        con=new ConectaBanco();
        String sSql=new String();
        sSql="Select * from Voucher where NumeroVoucher="+sNumVoucher+" ORDER BY NUMEROVOUCHER;";
        con.conecta();
         if(!con.conecta())
        {
            InOut.MsgDeErro("AppAdm","Erro ao conectar");
            return;            
        }
        con.executaSelect(sSql);
        
        lRes=con.resultset; 
        System.out.println(lRes);
        System.out.println(sSql);
        try 
        {           
            while (lRes.next())
            {
                 lIdVoucher =Integer.parseInt(lRes.getString("NumeroVoucher"));
                 Number.setText(lRes.getString("NumeroVoucher"));
                 Empresa1.setText(lRes.getString("Empresa"));
                 Tel1.setText(lRes.getString("Telefone"));
                 Cliente1.setText(lRes.getString("Usuario"));
                 Origem1.setText(lRes.getString("Origem"));
                 Destino1.setText(lRes.getString("Destino"));
                 Area1.setText(lRes.getString("Area"));
                 C_Custo1.setText(lRes.getString("Ccusto"));
                 SaidaHora1.setText(lRes.getString("Hsaida"));
                 KM_Inicial1.setText(lRes.getString("Kmsaida"));
                 ChegadaHora1.setText(lRes.getString("Hchegada"));
                 KM_Final1.setText(lRes.getString("kmchegada"));
                 KM_Rod1.setText(lRes.getString("kmfinal"));
                 TX_Emb1.setText(lRes.getString("txembarque"));
                 TX_Pedagio.setText(lRes.getString("pedagio"));
                 TX_Parado.setText(lRes.getString("horaparada"));
                 TX_Estacionamento.setText(lRes.getString("estacionamento"));
                 ValorTotal_KM.setText(lRes.getString("valorkm"));
                 Valor_Total.setText(lRes.getString("valortotal"));
                 Motorista.setText(lRes.getString("motorista"));
                 PlacaCarro.setText(lRes.getString("Placa"));
                 DataDia1.setSelectedItem(lRes.getString("datadia"));
                 DataMes.setSelectedItem(lRes.getString("datames"));
                 DataAno1.setSelectedItem(lRes.getString("dataano"));
                 
                 
                 
                 
                 
               
            }            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ExecutiveService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.desconecta();
    
}//GEN-LAST:event_TabPesqVoucherMouseClicked

private void AtualizaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtualizaMousePressed
// TODO add your handling code here:
        con=new ConectaBanco();
        String sSql=new String();
        sSql="Update Voucher set"
                + " Empresa='"+Empresa1.getText()+"'"
                + ", datames='"+DataMes.getSelectedItem()
                
               + "' where numerovoucher = "+Number.getText()+";";
        con.conecta();
         if(!con.conecta())
        {
            InOut.MsgDeErro("AppAdm","Erro ao conectar");
            return;            
        }
        System.out.println(sSql);
        con.executa(sSql);
        con.desconecta();
       // InOut.MsgDeInformacao(null,"INFORMAÇÕES ATUALIZADAS COM SUCESSO!!!" );
        this.LimpaCampos();
        populaTabela2(con.resultset);
        
        
    
}//GEN-LAST:event_AtualizaMousePressed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

private void NovoFormularioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NovoFormularioMousePressed
// TODO add your handling code here:
    this.LimpaCampos();
    TabPesqCliente.setVisible(false);
    TabPesqVoucher.setVisible(false);
    Number.requestFocusInWindow();
    Salva1.setVisible(true);
   
}//GEN-LAST:event_NovoFormularioMousePressed

private void CalculaValorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalculaValorMousePressed
// TODO add your handling code here:
    
    //Integer.parseInt("Aqui é a string");
        Double vlemb = Double.parseDouble(TX_Emb1.getText().replace(',', '.'));
        Double vlped = Double.parseDouble(TX_Pedagio.getText().replace(',', '.'));
        Double vlparado = Double.parseDouble(TX_Parado.getText().replace(',', '.'));
        Double vlestaciona = Double.parseDouble(TX_Estacionamento.getText().replace(',', '.'));
        Double vlkmrodado = Double.parseDouble(ValorTotal_KM.getText().replace(',','.'));
        Double vlkm = Double.parseDouble(KM_Rod1.getText());
        Double valorparado=vlparado*20;
        //Double vlkmrodado=vlkmunico*vlkm;
        Double calculo = vlemb+vlped+valorparado+vlestaciona+vlkmrodado;
       //ValorTotal_KM.setText(String.valueOf(vlkmrodado));
        Valor_Total.setText(String.valueOf(calculo).replace(',', '.'));
    
}//GEN-LAST:event_CalculaValorMousePressed

private void CalculaKMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalculaKMMousePressed
// TODO add your handling code here:
    Integer kminicial= Integer.parseInt(KM_Inicial1.getText().trim());
    Integer kmfinal= Integer.parseInt(KM_Final1.getText().trim());
    Integer kmrodado= kmfinal-kminicial;
    
          KM_Rod1.setText(String.valueOf(kmrodado).replace(',', '.'));
    //ValorTotal_KM.setText(String.valueOf(valortotal).replace(",","."));
}//GEN-LAST:event_CalculaKMMousePressed

private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
// TODO add your handling code here:
    Double valorkm=Double.parseDouble(ValorUnitario.getText().replace(',', '.'));
    Double vlkm = Double.parseDouble(KM_Rod1.getText().replace(',', '.'));
    Double valorkmfinal= valorkm*vlkm;
    ValorTotal_KM.setText(String.valueOf(valorkmfinal).replace(',', '.'));
}//GEN-LAST:event_jButton1MousePressed

private void ValorTotal_KMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorTotal_KMActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_ValorTotal_KMActionPerformed

private void TabPesqMotoristaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabPesqMotoristaMouseClicked
// TODO add your handling code here:
     String sMotorista = new String();
    int linha=0;
    linha=TabPesqMotorista.getSelectedRow();
    //Empresa1.setText(TabPesqCliente.getValueAt(linha, coluna).toString());
    
    sMotorista = TabPesqMotorista.getValueAt(linha, 0).toString();
    
    
       con=new ConectaBanco();
        String sSql=new String();
        sSql="Select NOME,PLACACARRO from CADMOTORISTA where NOME='"+sMotorista+"'ORDER BY NOME;";
        con.conecta();
         if(!con.conecta())
        {
            InOut.MsgDeErro("AppAdm","Erro ao conectar");
            return;            
        }
        con.executaSelect(sSql);
        
        lRes=con.resultset;        
        System.out.println(sSql);
        System.out.println(lRes);
        try 
        {           
            while (lRes.next())
            {
               
                 Motorista.setText(lRes.getString("NOME"));
               
                 PlacaCarro.setText(lRes.getString("PLACACARRO"));
                
                 
                 
                 
            }            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ExecutiveService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.desconecta();
  
}//GEN-LAST:event_TabPesqMotoristaMouseClicked

private void PesMotMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PesMotMousePressed

    con=new ConectaBanco();
        String sSql=new String();
         sSql="Select nome,cnh,modelocarro,ativo from cadmotorista where nome like'%"+PesquisaMotorista.getText()+"%'AND ATIVO='ATIVO'ORDER BY NOME;";
        con.conecta();
        con.executaSelect(sSql);
        System.out.println(sSql);
        populaTabela3(con.resultset);
        con.desconecta();
   
}//GEN-LAST:event_PesMotMousePressed

private void PesMotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesMotActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_PesMotActionPerformed

    private void jButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MousePressed
        // TODO add your handling code here:
        CancelaVoucher.setVisible(false);
    }//GEN-LAST:event_jButton6MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
        int verifica = 0;
        verifica = InOut.MsgDeSimNao("Cancelamento", "Deseja realmente cancelar?");
       System.out.println(verifica); 
       switch (verifica)
       {
           case 0:
               String sSql = new String();
               sSql="Update voucher set status='CANCELADO' WHERE NUMEROVOUCHER="+CancelaNumVoucher.getText()+";";
               con.conecta();
               con.executa(sSql);
               con.desconecta();
               break;
       }
               
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
        Cancelamento.setVisible(true);
    }//GEN-LAST:event_jButton4MousePressed

private void LimpaCampos()
{
    Number.setText("");
    Empresa1.setText("");
    Tel1.setText("");
    Cliente1.setText("");
    Origem1.setText("");
    Destino1.setText("");
    Area1.setText("");
    C_Custo1.setText("");
    SaidaHora1.setText("");
    KM_Inicial1.setText("");
    ChegadaHora1.setText("");
    KM_Final1.setText("");
    KM_Rod1.setText("");
    ValorTotal_KM.setText("");
    ValorUnitario.setText("");
    Valor_Total.setText("");
    Motorista.setText("");
    PlacaCarro.setText("");
    DataDia1.setSelectedItem("");
    DataMes.setSelectedItem("JANEIRO");
    DataAno1.setSelectedItem("");
    TX_Emb1.setText("");
    TX_Pedagio.setText("");
    TX_Parado.setText("");
    TX_Estacionamento.setText("");
    
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ExecutiveService().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Area1;
    private javax.swing.JButton Atualiza;
    private javax.swing.JTextField C_Custo1;
    private javax.swing.JButton CadCliente1;
    private javax.swing.JButton CalculaKM;
    private javax.swing.JButton CalculaValor;
    private javax.swing.JTextField CancelaNumVoucher;
    private javax.swing.JPanel CancelaVoucher;
    private javax.swing.JFrame Cancelamento;
    private javax.swing.JTextField ChegadaHora1;
    private javax.swing.JTextField Cliente1;
    private javax.swing.JComboBox DataAno1;
    private javax.swing.JComboBox DataDia1;
    private javax.swing.JComboBox DataMes;
    private javax.swing.JTextField Destino1;
    private javax.swing.JTextField Empresa1;
    private javax.swing.JButton Fecha1;
    private javax.swing.JTextField KM_Final1;
    private javax.swing.JTextField KM_Inicial1;
    private javax.swing.JTextField KM_Rod1;
    private javax.swing.JTextField Motorista;
    private javax.swing.JButton NovoFormulario;
    private javax.swing.JTextField Number;
    private javax.swing.JTextField Origem1;
    private javax.swing.JButton PesMot;
    private javax.swing.JTextField PesquisaCliente;
    private javax.swing.JTextField PesquisaMotorista;
    private javax.swing.JTextField PesquisaVoucher;
    private javax.swing.JTextField PlacaCarro;
    private javax.swing.JTextField SaidaHora1;
    private javax.swing.JButton Salva1;
    private javax.swing.JTextField TX_Emb1;
    private javax.swing.JTextField TX_Estacionamento;
    private javax.swing.JTextField TX_Parado;
    private javax.swing.JTextField TX_Pedagio;
    private javax.swing.JTable TabPesqCliente;
    private javax.swing.JTable TabPesqMotorista;
    private javax.swing.JTable TabPesqVoucher;
    private javax.swing.JTextField Tel1;
    private javax.swing.JLabel Usuario;
    private javax.swing.JTextField ValorTotal_KM;
    private javax.swing.JTextField ValorUnitario;
    private javax.swing.JTextField Valor_Total;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void populaTabela3(ResultSet resultset) {
        
        
        
        
          DefaultTableModel modelo1 = (DefaultTableModel) TabPesqMotorista.getModel();
       
        try {
        con=new ConectaBanco();
        
        String sSql = "select NOME,CNH,MODELOCARRO,ATIVO"
                + " from CADMOTORISTA where NOME ='"
                +PesquisaMotorista.getText()+"';";
        con.conecta();
         if(!con.conecta())
        {
            InOut.MsgDeErro("AppAdm","Erro ao conectar");
            return;            
        }
        con.executaSelect(sSql);
       
        System.out.println(sSql);
        lRes = con.resultset;      
        System.out.println(lRes);
            modelo1.setRowCount(0);
            while (lRes.next()) {
                modelo1.addRow(new Object[]{
                            lRes.getString("NOME"),
                            lRes.getString("CNH"),
                            lRes.getString("MODELOCARRO"),
                            lRes.getString("ATIVO"),
                            
        
                            
                            });

            }
            TabPesqMotorista.setModel(modelo1);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(PesquisaMotorista, ex);
        }
        con.desconecta();
}
}