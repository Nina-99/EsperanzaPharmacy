package Controller;

import Model.BillDAO;
import View.frmBill;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.print.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class BillController implements ActionListener {
    frmBill Bill = new frmBill();
    BillDAO billDAO = new BillDAO();
    int rowCount = 0;
    
    public BillController(frmBill Bill) {
        this.Bill = Bill;
        this.Bill.btnPrint.addActionListener(this);
        this.Bill.jMenuItem1.addActionListener(this);
        this.Bill.jMenuItem2.addActionListener(this);
        Initialize();
    }
    
    public void Initialize() {
        this.Bill.setExtendedState(MAXIMIZED_BOTH);
        //this.Bill.setLocationRelativeTo(null);
        Bill.jLabel16.setIcon(SImage("/Image/Pharmacy icon.png", Bill.jLabel16));
        modifySize();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Bill.btnPrint) {
            PrintBill();
        }else if (e.getSource() == Bill.jMenuItem1) {
            if (JOptionPane.showConfirmDialog(null, "Estás seguro de cerrarla?", "Cerrar aplicación", 1) == 0) {
                this.Bill.dispose();
            }
        }else if (e.getSource() == Bill.jMenuItem2) {
            JOptionPane.showMessageDialog(null, "Realizado por:\n\n   G.E.D.S.A.\n   2021\n\n\nConformado por:\n    Gualverto Canviri Gutierrez\n    Franz Cruz Arias\n    Marco Nina Nuñez", "Proyecto", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void PrintBill() {
        String nameBuyer = Bill.txtNameBuyer.getText();
        String nit = Bill.txtNitBuyer.getText();
        String addressBuyer = Bill.txtAddressBuyer.getText();
        String stringValues = "";
        int quantiy = 0;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String dateSale = simpleDateFormat.format(date);
        if (!nameBuyer.equals("") || !nit.equals("") || !addressBuyer.equals("")) {
                String ticket;
                String ticketByte;
                try {
                    String nameProduct[] = new String[100], p;
                    int total[] = new int[100];
                    float price[] = new float[100];
                    // Se crea la sentecia sql y se ejecuta para hacer la modificacion.
                    for (int i = 0; i < rowCount ; i++) {
                        nameProduct[i] = objectToString(Bill.Tproductos.getValueAt(i, 0));
                        p = objectToString(Bill.Tproductos.getValueAt(i, 1));
                        price[i] = Float.parseFloat(p);
                        String xe = objectToString(Bill.Tproductos.getValueAt(i, 2));
                        total[i] = Integer.parseInt(xe);
                        quantiy += total[i];
                    }
                    
                    String stringData = "Farmacia 'Esperanza'\n----------------------\nNIT: 1215678987\nBolivar entre Velazco Galvarro y Pagador N. 326  \nOruro-Bolivia\nFecha: " + dateSale 
                            + "\n----------------------\n\n\t>>Datos del Comprador<<\n\nNumero de Factura: " + Bill.jTnumfac.getText() + "\nNombre: " + nameBuyer + "\nRFC: " + nit + "\nDireccion: " + addressBuyer
                            + "\n----------------------\nCant.\t Producto\t Precio\n";
                    for (int i = 0; i < rowCount ; i++) {
                        stringValues += "" + total[i] + " \t" + nameProduct[i] + " \t" + price[i] * total[i] + " \n";
                    }
                    ticket = stringData + stringValues + "\n\nTotal: \t\t$" + Bill.txtTotal.getText() + "\n\n----------------------\n    CON EL CORAZON EN LAS MANOS\n    GRACIAS POR SU COMPRA.\n\n";
                    if (JOptionPane.showConfirmDialog(null, "Estás seguro de Imprimir? \n"+ ticket, "Confirmacion", 1) == 0) {
                        billDAO.AddBill(quantiy, nameBuyer, addressBuyer, nit, dateSale);
                        // Cogemos el servicio de impresión por defecto (impresora por defecto).
                        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
                        // Le decimos el tipo de datos que vamos a enviar a la impresora.
                        // Tipo: bytes Subtipo: autodetectado.
                        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
                        // Creamos un trabajo de impresión.
                        DocPrintJob pj = service.createPrintJob();
                        // Nuestro trabajo de impresión envía una cadena de texto.
                        ticketByte = new String(ticket);
                        byte[] bytes;
                        // Transformamos el texto a bytes que es lo que soporta la impresora.
                        bytes = ticketByte.getBytes();
                        // Creamos un documento (Como si fuese una hoja de Word para imprimir).
                        Doc doc = new SimpleDoc(bytes, flavor, null);
                        // Obligado coger la excepción PrintException.
                        // Mandamos a impremir el documento.
                        pj.print(doc, null);
                        ticket = "";

                        JOptionPane.showMessageDialog(null, "   Imprimiendo Factura");
                        this.Bill.dispose();
                    }
                } catch (PrintException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
        } else {
            JOptionPane.showMessageDialog(null, "Faltan Campos por Llenar");
        }
    }
    
    private void modifySize() {
        // Tamaño de la pantalla.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Bill.jPanel1.setLocation((screenSize.width / 2) - (Bill.jPanel1.getWidth() / 2), (screenSize.height / 4) - (Bill.jPanel1.getHeight() / 4));
    }
    
    public Icon SImage(String url, JLabel label) {
        ImageIcon image = new ImageIcon(getClass().getResource(url));
        ImageIcon _image = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return _image;
    }
    public String objectToString(Object o) {
        String st;
        st = (String) o;
        return st;
    }
    
    public void setTable(JTable datos) {
        this.Bill.Tproductos = datos;
    }
    
    public JTable getTable() {
        return this.Bill.Tproductos;
    }

    public void setTotal(String total) {
        Bill.txtTotal.setText(total);
    }

    public int getBill(int filas) {
        return filas;
    }

    public void setNum(int num) {
        String x = String.valueOf(num);
        Bill.jTnumfac.setText(x);
    }
    
    public void setRow(int j){
        rowCount = j;
    }
}
