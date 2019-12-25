package wangshangceshi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
@SuppressWarnings("serial")
public class AppStudent extends JFrame {

private JTextField nameField;
private JTextField PriceField;

private JTable table;
private DefaultTableModel model;
private String[] columns = { "�˵�", "����"};
private List data;
private Student tmp;

public AppStudent() {

data = new ArrayList();

getContentPane().setLayout(null);

JLabel lblName = new JLabel("�˵�");
lblName.setBounds(12, 10, 50, 13);
getContentPane().add(lblName);

nameField = new JTextField();
nameField.setBounds(74, 7, 96, 19);
getContentPane().add(nameField);
nameField.setColumns(10);

JLabel lblSex = new JLabel("����");
lblSex.setBounds(182, 10, 150, 13);
getContentPane().add(lblSex);

PriceField = new JTextField();
PriceField.setBounds(280, 7, 130, 19);
getContentPane().add(PriceField);
PriceField.setColumns(10);

JButton btnAdd = new JButton("���");
btnAdd.addActionListener(new ActionListener() {//�������¼���������ť���¡���һ����¼�����˵���ǰ��¼�����ӡ�
public void actionPerformed(ActionEvent e) {
add();
}
});
btnAdd.setBounds(0, 59, 67, 21);
getContentPane().add(btnAdd);

JButton btnDel = new JButton("ɾ��");
btnDel.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
del();
}
});
btnDel.setBounds(0, 99, 67, 21);
getContentPane().add(btnDel);

JButton btnUpdate = new JButton("�޸�");
btnUpdate.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
update();
}
});
btnUpdate.setBounds(0, 139, 67, 21);
getContentPane().add(btnUpdate);

JButton btnFind = new JButton("��ѯ");
btnFind.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {//���ڽ��ղ����¼����������ӿ�
find();
}
});
btnFind.setBounds(0, 179, 67, 21);
getContentPane().add(btnFind);

model = new DefaultTableModel(columns, 0);//������һ�����ģ��
table = new JTable(model);//����һ�����
table.addMouseListener(new MouseAdapter() {//�˱���ͨ�������ƣ������ڱ�����ݻ�λ�ȵȡ�����
public void mouseClicked(MouseEvent e) {
int row = table.getSelectedRow();//����table�����getselectedrow����������ֵ��ֵ�� index
nameField.setText((String) table.getValueAt(row, 0));//���ĵ�һ��
PriceField.setText((String) table.getValueAt(row, 1));//���ĵڶ���
tmp = getInput();
}
});
JScrollPane scrollPane = new JScrollPane(table);//ʹ�����Թ����鿴����
scrollPane.setBounds(69, 59,400, 250);
getContentPane().add(scrollPane);


setDefaultCloseOperation(EXIT_ON_CLOSE);//���ʹ����Ե���˳���������Դ���롣
setLocationRelativeTo(null);
setSize(601, 380);
setResizable(false);
setTitle("����һ����ҹʳ�ã�");
}

private Student getInput() {
Student stu = new Student();
stu.name = nameField.getText();
stu.Price = PriceField.getText();

return stu;
}

private void add() {
data.add(getInput());
showTable();

}

private void del() {
for (int i = 0; i < data.size(); i++) {
if (tmp.equals(data.get(i))) {
data.remove(i);
break;
}
}
showTable();
}

private void update() {
Student stu = getInput();
for (int i = 0; i < data.size(); i++) {
if (tmp.equals(data.get(i))) {
data.remove(i);
data.add(i, stu);
break;
}
}
showTable();
}

private void find() {
removeRows();
Student stu = getInput();
for (int i = 0; i < data.size(); i++) {
Student tmp = (Student) data.get(i);
if (tmp.equals(stu)) {
model.addRow(tmp.toArray());
break;
}
}
}

private void showTable() {
removeRows();
for (int i = 0; i < data.size(); i++) {
Student stu = (Student) data.get(i);
model.addRow(stu.toArray());//
}
}

private void removeRows() {
while (model.getRowCount() > 0) {
model.removeRow(0);//ɾ��ģ����0��λ��
}
}

public static void main(String[] args) {
new AppStudent();
}
}

