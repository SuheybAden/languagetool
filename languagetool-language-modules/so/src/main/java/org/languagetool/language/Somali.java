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

 import com.google.common.cache.CacheBuilder;
 import com.google.common.cache.CacheLoader;
 import com.google.common.cache.LoadingCache;
 import org.jetbrains.annotations.NotNull;
 import org.jetbrains.annotations.Nullable;
 import org.languagetool.*;
 import org.languagetool.chunking.Chunker;
 import org.languagetool.languagemodel.LanguageModel;
 import org.languagetool.rules.*;
 import org.languagetool.rules.patterns.PatternRuleLoader;
 import org.languagetool.rules.spelling.SpellingCheckRule;
 import org.languagetool.synthesis.Synthesizer;
 import org.languagetool.tagging.Tagger;
 import org.languagetool.tagging.disambiguation.Disambiguator;
 import org.languagetool.tokenizers.SRXSentenceTokenizer;
 import org.languagetool.tokenizers.SentenceTokenizer;
 import org.languagetool.tokenizers.Tokenizer;
 import org.languagetool.tools.Tools;
 
 import java.io.File;
 import java.io.IOException;
 import java.io.InputStream;
 import java.util.*;
 
 import static java.util.Arrays.asList;

/** 
 * @author Suheyb Aden
 */
public class Somali extends Language {

  @Override
  public SentenceTokenizer createDefaultSentenceTokenizer() {
    return new SRXSentenceTokenizer(this);
  }

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
    return new String[] {"SO"};
  }

  @Override
  public Contributor[] getMaintainers() {
    return new Contributor[] {
        new Contributor("Suheyb Aden")
    };
  }

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages, UserConfig userConfig, Language motherTongue, List<Language> altLanguages) throws IOException {
    return Arrays.asList();
  }

  @Override
  public LanguageMaintainedState getMaintainedState() {
    return LanguageMaintainedState.ActivelyMaintained;
  }
}
