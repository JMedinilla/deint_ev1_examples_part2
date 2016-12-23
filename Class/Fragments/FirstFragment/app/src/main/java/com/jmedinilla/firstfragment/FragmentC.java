package com.jmedinilla.firstfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class FragmentC extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentc, container, false);
        webView = (WebView)view.findViewById(R.id.web_fragmentc);
        webView.loadData(getResources().getString(R.string.html), "text/html", Xml.Encoding.UTF_8.toString());
        return view;
    }
}
