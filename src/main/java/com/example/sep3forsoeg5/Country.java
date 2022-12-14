package com.example.sep3forsoeg5;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.*;

public class Country implements Serializable
{
  private transient StringProperty countryName;
  private transient IntegerProperty marketSize;
  private transient IntegerProperty competitiveSituation;
  private transient IntegerProperty economicStability;
  private transient IntegerProperty politicalStability;
  private transient IntegerProperty inflation;
  private transient IntegerProperty culturalDifference;
  private transient IntegerProperty currentMarketShare;
  private transient IntegerProperty productsFit;
  private transient IntegerProperty uniquenessOfProduct;
  private transient IntegerProperty marketGrowth;
  private transient IntegerProperty needOfProduct;

  public int getNeedOfProduct()
  {
    return needOfProduct.get();
  }

  public IntegerProperty needOfProductProperty()
  {
    return needOfProduct;
  }

  public void setNeedOfProduct(int needOfProduct)
  {
    this.needOfProduct.set(needOfProduct);
  }


  public int getPoliticalStability()
  {
    return politicalStability.get();
  }

  public IntegerProperty politicalStabilityProperty()
  {
    return politicalStability;
  }

  public void setPoliticalStability(int politicalStability)
  {
    this.politicalStability.set(politicalStability);
  }

  public int getInflation()
  {
    return inflation.get();
  }

  public IntegerProperty inflationProperty()
  {
    return inflation;
  }

  public void setInflation(int inflation)
  {
    this.inflation.set(inflation);
  }

  public int getCulturalDifference()
  {
    return culturalDifference.get();
  }

  public IntegerProperty culturalDifferenceProperty()
  {
    return culturalDifference;
  }

  public void setCulturalDifference(int culturalDifference)
  {
    this.culturalDifference.set(culturalDifference);
  }

  public int getCurrentMarketShare()
  {
    return currentMarketShare.get();
  }

  public IntegerProperty currentMarketShareProperty()
  {
    return currentMarketShare;
  }

  public void setCurrentMarketShare(int currentMarketShare)
  {
    this.currentMarketShare.set(currentMarketShare);
  }

  public int getProductsFit()
  {
    return productsFit.get();
  }

  public IntegerProperty productsFitProperty()
  {
    return productsFit;
  }

  public void setProductsFit(int productsFit)
  {
    this.productsFit.set(productsFit);
  }

  public int getUniquenessOfProduct()
  {
    return uniquenessOfProduct.get();
  }

  public IntegerProperty uniquenessOfProductProperty()
  {
    return uniquenessOfProduct;
  }

  public void setUniquenessOfProduct(int uniquenessOfProduct)
  {
    this.uniquenessOfProduct.set(uniquenessOfProduct);
  }

  public int getMarketGrowth()
  {
    return marketGrowth.get();
  }

  public IntegerProperty marketGrowthProperty()
  {
    return marketGrowth;
  }

  public void setMarketGrowth(int marketGrowth)
  {
    this.marketGrowth.set(marketGrowth);
  }
  public String getCountryName()
  {
    return countryName.get();
  }

  public StringProperty countryNameProperty()
  {
    return countryName;
  }

  public IntegerProperty marketSizeProperty()
  {
    return marketSize;
  }

  public void setCountryName(String countryName)
  {
    this.countryName.set(countryName);
  }

  public int getMarketSize()
  {
    return marketSize.get();
  }
  public void setMarketSize(int marketSize)
  {
    this.marketSize.set(marketSize);
  }
  public int getCompetitiveSituation()
  {
    return competitiveSituation.get();
  }
  public void setCompetitiveSituation(int competitiveSituation)
  {
    this.competitiveSituation.set(competitiveSituation);
  }

  public IntegerProperty economicStability()
  {
    return economicStability;
  }
  public int getEconomicStability()
  {
    return economicStability.get();
  }

  public void setEconomicStability(int economicStability)
  {
    this.economicStability.set(economicStability);
  }


//  ----------------------------------------------------------------------------




  Country()
  {
    this.countryName          = new SimpleStringProperty(this, "countryName");
    this.marketSize           = new SimpleIntegerProperty(this, "marketSize");
    this.marketGrowth         = new SimpleIntegerProperty(this,"marketGrowth");
    this.competitiveSituation = new SimpleIntegerProperty(this, "competitiveSituation");
    this.economicStability    = new SimpleIntegerProperty(this,"economicStability");
    this.politicalStability   = new SimpleIntegerProperty(this, "politicalStability");
    this.inflation            = new SimpleIntegerProperty(this,"inflation");
    this.culturalDifference   = new SimpleIntegerProperty(this, "culturalDifference");
    this.currentMarketShare   = new SimpleIntegerProperty(this, "currentMarketShare");
    this.productsFit          = new SimpleIntegerProperty(this, "productsFit");
    this.uniquenessOfProduct  = new SimpleIntegerProperty(this, "uniquenessOfProduct");
    this.needOfProduct        = new SimpleIntegerProperty(this, "needOfProduct");

  }

  Country(String countryName,
      int marketSize,
      int marketGrowth,
      int competitiveSituation,
      int economicSituation,
      int politicalStability,
      int inflation,
      int culturalDifference,
      int currentMarketShare,
      int productsFit,
      int uniquenessOfProduct,
      int needOfProduct)
  {
    this();
    setCountryName(countryName);
    setMarketSize(marketSize);
    setMarketGrowth(marketGrowth);
    setCompetitiveSituation(competitiveSituation);
    setEconomicStability(economicSituation);
    setPoliticalStability(politicalStability);
    setInflation(inflation);
    setCulturalDifference(culturalDifference);
    setCurrentMarketShare(currentMarketShare);
    setProductsFit(productsFit);
    setUniquenessOfProduct(uniquenessOfProduct);
    setNeedOfProduct(needOfProduct);

  }

  @Serial private void writeObject(ObjectOutputStream s) throws IOException
  {
    s.defaultWriteObject();
    s.writeObject(getCountryName());
    s.writeObject(getMarketSize());
    s.writeObject(getMarketGrowth());
    s.writeObject(getCompetitiveSituation());
    s.writeObject(getEconomicStability());
    s.writeObject(getPoliticalStability());
    s.writeObject(getInflation());
    s.writeObject(getCulturalDifference());
    s.writeObject(getCurrentMarketShare());
    s.writeObject(getProductsFit());
    s.writeObject(getUniquenessOfProduct());
    s.writeObject(getNeedOfProduct());
  }

  @Serial private void readObject(ObjectInputStream s)
      throws IOException, ClassNotFoundException
  {
    s.defaultReadObject();
    countryName          = new SimpleStringProperty((String) s.readObject());
    marketSize           = new SimpleIntegerProperty((int) s.readObject());
    marketGrowth         = new SimpleIntegerProperty((int) s.readObject());
    competitiveSituation = new SimpleIntegerProperty((int) s.readObject());
    economicStability    = new SimpleIntegerProperty((int) s.readObject());
    politicalStability   = new SimpleIntegerProperty((int) s.readObject());
    inflation            = new SimpleIntegerProperty((int) s.readObject());
    culturalDifference   = new SimpleIntegerProperty((int) s.readObject());
    currentMarketShare   = new SimpleIntegerProperty((int) s.readObject());
    productsFit          = new SimpleIntegerProperty((int) s.readObject());
    uniquenessOfProduct  = new SimpleIntegerProperty((int) s.readObject());
    needOfProduct        = new SimpleIntegerProperty((int) s.readObject());

  }


}
