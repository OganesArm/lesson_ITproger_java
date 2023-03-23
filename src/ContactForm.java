import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField name_field, email_field;
    JRadioButton male, female;
    JCheckBox check;
    public ContactForm(){
        super("Контактная форма");
        super.setBounds(200, 100, 300, 300); //расположение и ширина и высота
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // нажал на крестик и закрылось приложение

        Container container=super.getContentPane(); //метод возвращает необходымй контейнер
        container.setLayout(new GridLayout(5,2,2,10)); // настраиваем как будет выглядить

        JLabel name = new JLabel("Введите имя: ");
        name_field=new JTextField("",1);
        JLabel email = new JLabel("Введите email: ");
        email_field=new JTextField("@",1);

        container.add(name);
        container.add(name_field);
        container.add(email);
        container.add(email_field);

        male = new JRadioButton("Men");
        female = new JRadioButton("Women");
        check = new JCheckBox("Ok?", false); // поставлена или не поставлена галочка
        JButton send_button = new JButton("Отправить");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();  //создаем отдельную группу, чтобы нельзя было выбрать оба варианта
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager());
    }
    class ButtonEventManager implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = name_field.getText();
            String email = email_field.getText();

            String isMale= "Men";
            if (!male.isSelected())     //проверка
                isMale="Women";

            boolean checkBox = check.isSelected();

            JOptionPane.showMessageDialog(null, "Ваша почта: "+email+"\nВаш пол: "+isMale+"\nВаше согласие: "+checkBox,
                    "Привет, "+name, JOptionPane.PLAIN_MESSAGE); // без привязки/сообщение пользователю/название поля/тип всплывающего окна
        }
    }
}
