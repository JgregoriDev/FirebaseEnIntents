package josep.com.firebaseenintents;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends MenuMain {
    private DatabaseReference ultim_numero;
    private DatabaseReference actual_numero;
    private TextView torn;
    private int n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        ultim_numero = firebaseDatabase.getReference("ultim_numero");
        actual_numero = firebaseDatabase.getReference("actual_numero");
        torn= (TextView) findViewById(R.id.torn);
        ultim_numero.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                n=Integer.parseInt(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        this.setN_ultim_numero(n);
        torn.setText("Torn:\n"+this.getN_ultim_numero());
    }

}
