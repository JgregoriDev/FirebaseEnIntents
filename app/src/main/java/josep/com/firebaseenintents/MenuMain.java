package josep.com.firebaseenintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MenuMain extends AppCompatActivity {

    private int n_ultim_numero;
    private int n_actual_numero;

    public int getN_ultim_numero() {
        return n_ultim_numero;
    }

    public void setN_ultim_numero(int n_ultim_numero) {
        this.n_ultim_numero = n_ultim_numero;
    }

    public int getN_actual_numero() {
        return n_actual_numero;
    }

    public void setN_actual_numero(int n_actual_numero) {
        this.n_actual_numero = n_actual_numero;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent = null;
        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.Inici:
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.Agafar_numero:
                intent = new Intent(this, Agafar_numero.class);
                break;
            case R.id.Atendre_client:
                intent = new Intent(this, Atendre_client.class);
                break;
        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
