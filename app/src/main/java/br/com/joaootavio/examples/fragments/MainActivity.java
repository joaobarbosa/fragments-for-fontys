package br.com.joaootavio.examples.fragments;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup contentGroup = (RadioGroup) findViewById(R.id.content_radio_group);
        final RadioGroup fragmentGroup = (RadioGroup) findViewById(R.id.fragment_radio_group);
        Button loadButton = (Button) findViewById(R.id.load_button);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, content;
                int fragmentId;
                int contentRadioId = contentGroup.getCheckedRadioButtonId();
                int fragmentRadioId = fragmentGroup.getCheckedRadioButtonId();

                switch(contentRadioId) {
                    case R.id.radio_lorem:
                        title = getString(R.string.lorem_ipsum_title);
                        content = getString(R.string.lorem_ipsum_paragraph);
                        break;
                    case R.id.radio_bacon:
                        title = getString(R.string.bacon_ipsum_title);
                        content = getString(R.string.bacon_ipsum_paragraph);
                        break;
                    default:
                    case R.id.radio_samuel:
                        title = getString(R.string.samuel_l_ipsum_title);
                        content = getString(R.string.samuel_l_ipsum_paragraph);
                        break;
                }

                switch (fragmentRadioId) {
                    case R.id.radio_fragment_a:
                        fragmentId = R.layout.fragment_a;
                        break;
                    case R.id.radio_fragment_b:
                        fragmentId = R.layout.fragment_b;
                        break;
                    default:
                    case R.id.radio_fragment_c:
                        fragmentId = R.layout.fragment_c;
                        break;
                }

                Intent i = new Intent(MainActivity.this, FragmentActivity.class);

                i.putExtra(FragmentActivity.TITLE_EXTRA, title);
                i.putExtra(FragmentActivity.CONTENT_EXTRA, content);
                i.putExtra(FragmentActivity.FRAGMENT_EXTRA, fragmentId);

                MainActivity.this.startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_credits) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
