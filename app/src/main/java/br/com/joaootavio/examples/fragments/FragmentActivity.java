package br.com.joaootavio.examples.fragments;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentActivity extends ActionBarActivity {

    public static final String TITLE_EXTRA = "title";
    public static final String CONTENT_EXTRA = "content";

    private static String fragmentTitle;
    private static String fragmentContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            finish();
        }

        fragmentTitle = extras.getString(TITLE_EXTRA);
        fragmentContent = extras.getString(CONTENT_EXTRA);

        if (savedInstanceState == null) {
            Fragment instance;

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ExampleFragment())
                    .commit();
        }
    }

    public static class ExampleFragment extends Fragment {

        public ExampleFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_example, container, false);

            TextView title = (TextView) rootView.findViewById(R.id.fragment_a_title);
            TextView content = (TextView) rootView.findViewById(R.id.fragment_a_content);

            title.setText(fragmentTitle);
            content.setText(fragmentContent);

            return rootView;
        }
    }
}
