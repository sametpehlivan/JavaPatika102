package com.patika.view;

import com.patika.Helper.Config;
import com.patika.Helper.Helper;
import com.patika.dao.UserDao;
import com.patika.model.Operator;
import com.patika.model.Role;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OperatorGUI extends JFrame
{
    private JPanel wrapper;
    private JTabbedPane tab;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JTable table_user_table;
    private JScrollPane scrolpane_user_pane;
    private JLabel lbl_username;
    private JTextField txt_username;
    private JLabel lbl_password;
    private JPasswordField txt_password;
    private JButton btn_add_user;
    private JTextField txt_name;
    private JTextField txt_surname;
    private JComboBox cmb_bx_roles;
    private JPanel panel_add_form;
    private DefaultTableModel model_user_list;
    private  DefaultComboBoxModel model_cmb_bx_roles;
    private Object[] role_list;
    private Object[] row_user_list;
    private final Operator operator;
    private final UserDao userDao = new UserDao();
    private final List<String> textFieldList = new ArrayList<String>();
    public void setPlaceHolders()
    {
        for(Component c :  panel_add_form.getComponents()){
            if (c instanceof JTextField)
            {
                JTextField textField = (JTextField) c;
                textField.setForeground(Color.GRAY);
                String text = textField.getText();
                textFieldList.add(text.trim().toLowerCase());
                textField.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (textField.getText().equals(text)) {
                            textField.setText("");
                            textField.setForeground(Color.BLACK);
                        }
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        if (textField.getText().isEmpty()) {
                            textField.setForeground(Color.GRAY);
                            textField.setText(text);
                        }
                    }
                });
            }
        }

    }
    public void setRoleComboBox()
    {
        model_cmb_bx_roles = new DefaultComboBoxModel();

        for (Role role : Role.values())
        {
            model_cmb_bx_roles.addElement(new ComboKeyValue(role.getRole(),role.getRole().toUpperCase()));

        }
        cmb_bx_roles.setModel(model_cmb_bx_roles);
    }
    public void setTable()
    {
        model_user_list = new DefaultTableModel();
        Object[] column_user_list = {"ID","NAME","SURNAME","USERNAME","PASSWORD","ROLE DESCRIPTION"};
        model_user_list.setColumnIdentifiers(column_user_list);
        table_user_table.setModel(model_user_list);
        userDao.getList(null).forEach(u-> {
            model_user_list.addRow(new Object[]{u.getId(),u.getName(),u.getSurname(),u.getUsername(),u.getPassword(),u.getRole()});
        });
    }
    public void setButtonListener()
    {
        btn_add_user.addActionListener(click -> {
            boolean flag = true;
            String  messages = "";
            for(Component c :  panel_add_form.getComponents())
            {
                if(c instanceof  JPasswordField)
                {
                    JPasswordField textField = (JPasswordField) c;
                    if (!(textField.getPassword().length > 0))
                    {
                        flag = false;
                        messages = "\n"+"Password requıred!";
                    }
                }
                else if (c instanceof JTextField) {
                    JTextField textField = (JTextField) c;
                    String text = textField.getText().trim().toLowerCase();
                    if(textFieldList.contains(text))
                    {
                        flag = false;
                        messages += "\n" + text + " requıred!";
                    }
                }

            }
            if (!flag) JOptionPane.showMessageDialog(null,messages.toUpperCase(),"ERROR!",JOptionPane.ERROR_MESSAGE);
        });
    }
    public OperatorGUI(Operator operator)
    {
        this.operator=operator;
        add(wrapper);
        setSize(600,600);
        Helper.setLocationCenter(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.TITLE);
        setVisible(true);
        setTable();
        setPlaceHolders();
        setRoleComboBox();
        setButtonListener();
    }

    public static void main(String[] args)
    {
        var operator = new Operator(1,"samet","pehlivan","sametpehlivan","samet1234");
        Helper.setLayout();
        OperatorGUI gui = new OperatorGUI(operator);
    }
}
