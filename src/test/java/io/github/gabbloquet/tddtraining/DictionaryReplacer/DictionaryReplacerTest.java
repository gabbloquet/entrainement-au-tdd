package io.github.gabbloquet.tddtraining.DictionaryReplacer;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DictionaryReplacerTest {

  private final DictionaryReplacer dictionaryReplacer = new DictionaryReplacer();

  @Test
  void should_return_an_empty_string_if_entry_is_empty() {
    String entry = "";
    Map<String, String> dictionary = Map.of();

    assertThat(dictionaryReplacer.replace(entry, dictionary)).isEqualTo("");
  }

  @Test
  void should_return_a_toto_string_if_entry_is_toto() {
    String entry = "toto";
    Map<String, String> dictionary = Map.of();

    assertThat(dictionaryReplacer.replace(entry, dictionary)).isEqualTo("toto");
  }

  @Test
  void should_replace_$temp$_by_temporary_if_temp_equals_temporary_in_dictionary() {
    String entry = "$temp$";
    Map<String, String> dictionary = Map.of("temp", "temporary");

    assertThat(dictionaryReplacer.replace(entry, dictionary)).isEqualTo("temporary");
  }

  @Test
  void should_replace_$name$_by_Gabin_if_name_equals_Gabin_in_dictionary() {
    String entry = "$name$";
    Map<String, String> dictionary = Map.of("name", "Gabin");

    assertThat(dictionaryReplacer.replace(entry, dictionary)).isEqualTo("Gabin");
  }

  @Test
  void should_replace_$name$_by_Gabin_and_add_the_welcome_message() {
    String entry = "$name$, bienvenue !!";
    Map<String, String> dictionary = Map.of("name", "Gabin");

    assertThat(dictionaryReplacer.replace(entry, dictionary)).isEqualTo("Gabin, bienvenue !!");
  }

  @Test
  void should_replace_$name$_by_Gabin_and_$temp$_by_temporary() {
    String entry = "$temp$ here comes the name $name$";
    Map<String, String> dictionary = Map.of("name", "Gabin", "temp", "temporary");

    assertThat(dictionaryReplacer.replace(entry, dictionary)).isEqualTo("temporary here comes the name Gabin");
  }
}
