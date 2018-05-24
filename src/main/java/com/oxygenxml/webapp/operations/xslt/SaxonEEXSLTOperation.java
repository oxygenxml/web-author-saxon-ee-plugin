package com.oxygenxml.webapp.operations.xslt;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;

import org.xml.sax.XMLReader;

import com.saxonica.config.EnterpriseConfiguration;

import net.sf.saxon.TransformerFactoryImpl;
import ro.sync.ecss.extensions.api.AuthorAccess;
import ro.sync.ecss.extensions.api.WebappCompatible;
import ro.sync.ecss.extensions.commons.operations.TransformOperation;
import ro.sync.exml.workspace.api.PluginWorkspaceProvider;


/**
 * XSLT Operation based on Saxon EE.
 * 
 * @author cristi_talau
 */
@WebappCompatible
public class SaxonEEXSLTOperation extends TransformOperation {
  /**
   * The transformer factory.
   */
  private TransformerFactory factory;

  /**
   * Constructor.
   */
  public SaxonEEXSLTOperation() {
    EnterpriseConfiguration enterpriseConfiguration = new EnterpriseConfiguration();
    this.factory = new TransformerFactoryImpl(enterpriseConfiguration);
  }

  @Override
  protected Transformer createTransformer(AuthorAccess authorAccess, Source source) throws TransformerConfigurationException {
    Transformer delegate = SaxonEEXSLTOperation.this.factory.newTransformer(source);
    
    return new TransformerWrapper(delegate) {
      
      @Override
      public void transform(Source source, Result outputTarget) throws TransformerException {
        if (source instanceof SAXSource) {
          SAXSource saxSource = (SAXSource) source;
          if (saxSource.getXMLReader() == null) {
            // Specify an XML reader that uses the Oxygen's catalog.
            XMLReader xmlReader = PluginWorkspaceProvider.getPluginWorkspace().getXMLUtilAccess().newNonValidatingXMLReader();
            source = new SAXSource(xmlReader, saxSource.getInputSource());
          }
        }
        super.transform(source, outputTarget);
      }
    };
  }
}
