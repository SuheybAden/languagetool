/* LanguageTool, a natural language style checker 
 * Copyright (C) 2011 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */

 package org.languagetool.language;


 import org.jetbrains.annotations.Nullable;
import org.languagetool.*;
 import org.languagetool.rules.*;
import org.languagetool.rules.so.MorfologikSomaliSpellerRule;
import org.languagetool.rules.spelling.SpellingCheckRule;
import org.languagetool.rules.spelling.hunspell.HunspellRule;
import org.languagetool.tokenizers.SRXSentenceTokenizer;
 import org.languagetool.tokenizers.SentenceTokenizer;

 import java.io.IOException;
 import java.util.*;
 
 import static java.util.Arrays.asList;

/** 
 * @author Suheyb Aden
 */
public class Somali extends Language {

  @Override
  public String getName() {
    return "Somali";
  }

  @Override
  public String getShortCode() {
    return "so";
  }

  @Override
  public String[] getCountries() {
    return new String[] {"SO", "ET", "KE"};
  }

  @Override
  public Contributor[] getMaintainers() {
    return new Contributor[] {
        new Contributor("Suheyb Aden")
    };
  }

  @Override
  public SentenceTokenizer createDefaultSentenceTokenizer() {
    return new SRXSentenceTokenizer(this);
  }

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages, UserConfig userConfig, Language motherTongue, List<Language> altLanguages) throws IOException {
    return Arrays.asList(
      new MorfologikSomaliSpellerRule(messages, this, userConfig, altLanguages),
      new CommaWhitespaceRule(messages),
      new DoublePunctuationRule(messages),
      new GenericUnpairedBracketsRule(messages),
      new UppercaseSentenceStartRule(messages, this),
      new WordRepeatRule(messages, this),
      new MultipleWhitespaceRule(messages, this),
      new SentenceWhitespaceRule(messages)
      );
  }

  @Override
  public LanguageMaintainedState getMaintainedState() {
    return LanguageMaintainedState.ActivelyMaintained;
  }

  @Nullable
  @Override
  protected SpellingCheckRule createDefaultSpellingRule(ResourceBundle messages) throws IOException {
    return new MorfologikSomaliSpellerRule(messages, this, null, null);
  }
}
