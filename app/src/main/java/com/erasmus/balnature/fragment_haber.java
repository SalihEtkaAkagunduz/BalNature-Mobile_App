package com.erasmus.balnature;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class fragment_haber extends Fragment {

    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ff=inflater.inflate(R.layout.fragment_haber, container, false);
        WebView web=(WebView) ff.findViewById(R.id.aaaa);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://63c848d70d365.site123.me/");
        swipeRefreshLayout = ff.findViewById(R.id.swipeRefreshLayout2);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Yenileme işlemlerini burada gerçekleştirin
                // Örneğin, verileri yeniden yükleme, ağ isteği yapma, vb.
web.reload();
                // Yenileme işlemi tamamlandığında animasyonu durdurun
                web.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        // Sayfa yükleme işlemi tamamlandığında buraya gelecektir.
                        // Burada yapılacak işlemleriniz varsa ekleyebilirsiniz.,
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });
        // Inflate the layout for this fragment
        return ff;  }
}