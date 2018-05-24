package com.oxygenxml.webapp.operations.xslt;

import java.util.Properties;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;

public class TransformerWrapper extends Transformer {

  private Transformer delegate;

  public TransformerWrapper(Transformer delegate) {
    this.delegate = delegate;
  }
  
  @Override
  public void clearParameters() {
    delegate.clearParameters();
  }

  @Override
  public ErrorListener getErrorListener() {
    return delegate.getErrorListener();
  }

  @Override
  public Properties getOutputProperties() {
    return delegate.getOutputProperties();
  }

  @Override
  public String getOutputProperty(String name) throws IllegalArgumentException {
    return delegate.getOutputProperty(name);
  }

  @Override
  public Object getParameter(String name) {
    return delegate.getParameter(name);
  }

  @Override
  public URIResolver getURIResolver() {
    return delegate.getURIResolver();
  }

  @Override
  public void setErrorListener(ErrorListener listener) throws IllegalArgumentException {
    delegate.setErrorListener(listener);
  }

  @Override
  public void setOutputProperties(Properties oformat) {
    delegate.setOutputProperties(oformat);
  }

  @Override
  public void setOutputProperty(String name, String value) throws IllegalArgumentException {
    delegate.setOutputProperty(name, value);
  }

  @Override
  public void setParameter(String name, Object value) {
    delegate.setParameter(name, value);
  }

  @Override
  public void setURIResolver(URIResolver resolver) {
    delegate.setURIResolver(resolver);
  }

  @Override
  public void transform(Source xmlSource, Result outputTarget) throws TransformerException {
    delegate.transform(xmlSource, outputTarget);
  }

}
