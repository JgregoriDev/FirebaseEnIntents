package josep.com.firebaseenintents;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Atendre_client extends MenuMain {
    private DatabaseReference actual_numero;
    private Button b_nou;
    private Button b_reiniciar;
    private TextView text_num_acual_cua;
    private int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendre_client);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        actual_numero =db.getReference("actual_numero");
        text_num_acual_cua = (TextView) findViewById(R.id.text_NumFb);
        b_nou= (Button) findViewById(R.id.b_agafarNumero);
        //b_reiniciar= (Button) findViewById(R.id.b_reiniciar);
//        b_nou.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NouClient(view);
//            }
//        });

    }

    public void NouClient(View view) {
        actual_numero.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valor=dataSnapshot.getValue(String.class);
                n=Integer.parseInt(valor);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        n++;
        setN_actual_numero(n);
        text_num_acual_cua.setText(""+getN_actual_numero());
        actual_numero.setValue(""+getN_actual_numero());
    }
}
