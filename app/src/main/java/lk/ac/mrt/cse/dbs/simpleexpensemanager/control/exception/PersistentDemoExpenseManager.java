package lk.ac.mrt.cse.dbs.simpleexpensemanager.control.exception;

import android.content.Context;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.control.ExpenseManager;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.AccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.TransactionDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentMemoryAccountDAO;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.impl.PersistentMemoryTransactionDAO;

public class PersistentDemoExpenseManager extends ExpenseManager {
    private Context context;

    public PersistentDemoExpenseManager(Context cont){
        this.context = cont;
        try {
            setup();
        } catch (ExpenseManagerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setup() throws ExpenseManagerException {

        TransactionDAO PMT_DAO = new PersistentMemoryTransactionDAO(context);
        setTransactionsDAO(PMT_DAO);

        AccountDAO PMA_DAO = new PersistentMemoryAccountDAO(context);
        setAccountsDAO(PMA_DAO);

    }
}
