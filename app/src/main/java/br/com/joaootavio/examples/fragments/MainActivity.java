package br.com.joaootavio.examples.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DialerFilter;
import android.widget.RadioGroup;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioGroup contentGroup = (RadioGroup) findViewById(R.id.content_radio_group);
        Button loadButton = (Button) findViewById(R.id.load_button);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, content;
                int fragmentId;
                int contentRadioId = contentGroup.getCheckedRadioButtonId();

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

                Intent i = new Intent(MainActivity.this, FragmentActivity.class);

                i.putExtra(FragmentActivity.TITLE_EXTRA, title);
                i.putExtra(FragmentActivity.CONTENT_EXTRA, content);

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

    private void showCreditsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setNeutralButton(R.string.dismiss, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setView(R.id.dialog)
                .show();
    }
}
