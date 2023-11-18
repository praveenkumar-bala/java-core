package org.pk.annotation_plus_reflection_real_time_examples.custom.orm.application;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        TransactionHistory praveen = new TransactionHistory(1, "Praveen", 1000, "Credit");
        TransactionHistory kayal = new TransactionHistory(1, "kayal", 200,"Debit");
        TransactionHistory kannan = new TransactionHistory(1, "kannan", 3000,"Credit");
        TransactionHistory kumar = new TransactionHistory(1, "kumar", 4000,"Debit");


        Hibernate<TransactionHistory> hibernate = Hibernate.getConnection();
//        hibernate.write(praveen);
//        hibernate.write(kayal);
//        hibernate.write(kannan);
//        hibernate.write(kumar);


//        List<TransactionHistory> all = hibernate.findAll(TransactionHistory.class);
//        all.stream().map(TransactionHistory::toString).forEach(System.out::println);

        TransactionHistory transactionHistory = hibernate.fiindById(TransactionHistory.class, 1);
        System.out.println(transactionHistory.toString());

        transactionHistory.setAmount(10000.0);
        TransactionHistory transactionHistoryUpdated = hibernate.update(transactionHistory);

        transactionHistory = hibernate.fiindById(TransactionHistory.class, 1);
        System.out.println(transactionHistory.toString());
    }
}
