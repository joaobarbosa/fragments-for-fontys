package br.com.joaootavio.examples.fragments;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.inputmethod.ExtractedTextRequest;


public class FragmentActivity extends ActionBarActivity {

    public static final String TITLE_EXTRA = "title";
    public static final String CONTENT_EXTRA = "content";
    public static final String FRAGMENT_EXTRA = "fragment";

    private String fragmentTitle;
    private String fragmentContent;
    private int fragmentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            fragmentTitle = extras.getString(TITLE_EXTRA);
            fragmentContent = extras.getString(CONTENT_EXTRA);
            fragmentId = extras.getInt(FRAGMENT_EXTRA);
        }

        if (savedInstanceState == null) {
            Fragment instance;

            switch (fragmentId) {
                case R.layout.fragment_a:
                    instance = new AFragment();
                    break;
                case R.layout.fragment_b:
                    instance = new BFragment();
                    break;
                default:
                case R.layout.fragment_c:
                    instance = new CFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, instance)
                    .commit();
        }
    }

    public static class AFragment extends Fragment {

        public AFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_a, container, false);
            return rootView;
        }
    }

    public static class BFragment extends Fragment {

        public BFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_b, container, false);
            return rootView;
        }
    }

    public static class CFragment extends Fragment {

        public CFragment() {}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_c, container, false);
            return rootView;
        }
    }
}
