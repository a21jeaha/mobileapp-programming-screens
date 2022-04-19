
# Rapport 4 Activity & Intent

En ny aktivitet skapades 

![](new_activity.jpg)

Följande error meddelande erhölls vid startandet av applikationen `AAPT: error: resource android:color/system neutral 1_1000 not found.`, detta löstes genom att i `build.gradel (Module:Screens.app)` göra dessa ändringar.

```
android {
    compileSdkVersion 31                /// ändrad från 30 till 31
    buildToolsVersion "30.0.3"

    defaultConfig {
        applicationId "com.example.screens"
        minSdkVersion 16
        targetSdkVersion 31             /// ändrad från 30 till 31
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
```

En knapp widget skapas i activity_main.xml genom koden nedan, den textview som tidigare funnits i filen raderades. Vidare initieras knappen i `MainActivity.java`.

```
<Button
        android:id="@+id/get2activity2"                     // ger knappen ett ID som kommer användas senare 
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/tap_to_go_to_second_activity" // sätter den text som står på knappen 
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:layout_marginTop="250dp"/>                  // sänker knappen 250dp från toppen av skärmen 
```
```
public class MainActivity extends AppCompatActivity {

    Button toSecondActivity;                                    // en knapp deklareras

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        toSecondActivity = findViewById(R.id.get2activity2);    // knappen associeras till knapp-widgeten via dess ID
    }
}
```

En lyssnare för knappen skapas, där den vid registrering av knapptryck skickar ett metodanrop till `onButtonTap` varvid en intent skapas och ett string värde kopplas till det.

```
toSecondActivity.setOnClickListener(new View.OnClickListener() {   // en lyssnare för knappen initieras
            @Override
            public void onClick(View view) {
                onButtonTap();                 // skickar ett metod anrop till metoden som skickar intent
            }
        });
```
```
 private void onButtonTap(){
        Intent intent = new Intent (this, SecondActivity.class); // här skappas en intent som agerar från DENNA klass, och öppnar klassen SecondActivity.class
        intent.putExtra("NAME", "Jean-Paul Hanna"); // här skickas en sträng med NYCKEL "NAME", vid mottagar sidan måste samma nyckel anges
        startActivity(intent); // intenten activeras!!
    }
```
Det fortsatta arbetet utförs i `activity_second.xml` där en textView skapas som senare tar emot text strängen skickat från _MainActivity_ via intenten. 

```
<TextView
    android:id="@+id/secondactivity"                // ID för att hitta denna textView senare
    tools:text="this is text"                       // en temporär text, som inte kommer att synnas i applicationen, den text som kommer synnas är den sträng som skickas via intenten 
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    android:gravity="center"                        // centrerar texten i mitten av skärmen
    />
```

I `SecondActivity.java` deklarerar vi en TextView variabel som kommer att initieras med ID:t skapat för TextView, denna kommer sedan att erhålla en text sträng som skickas med intenten. 
Strängen tas emot genom extras (en instance av Bundle klassen).

```
public class SecondActivity extends AppCompatActivity {
    TextView textView;                                                   // en TextView deklareras 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();                        // Här initieras en "Bundle", denna kommer användas för att ta emot data från en intent.
       
        textView = (TextView) findViewById(R.id.secondactivity);        // TextViewn initieras genom det ID som skapades innan 
        textView.setText(extras.getString("NAME"));                     // en text sträng sätts i textViewn taget från variabeln extras (Bundle) som i sin tur
                                                                        // fått denna sträng vid skapandet av intenten som öppna denna sida 
    }
}
```
![](activitymain.png)
![](secondactivity.png)