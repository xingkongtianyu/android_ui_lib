package fr.baloomba.ui_lib;

public interface SmartListView {

    // <editor-fold desc="METHODS">

    public abstract void noMoreResult();

    public abstract void noResult();

    public void showLoading();

    public void dismissLoading();

    public void showFooter();

    public void hideFooter();

    public void showHeader();

    public void hideHeader();

    // </editor-fold>

}
