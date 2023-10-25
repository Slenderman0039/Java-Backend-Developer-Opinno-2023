package esercizio2;

import java.util.*;
import java.util.function.BiFunction;

public class MultiMappa {


    private HashMap<String, List<Studente>> esami;


    public MultiMappa() {
        esami = new HashMap<>();
    }

    public void put(String esame, List<Studente> v) {
        esami.put(esame, v);
        System.out.println("Hai inserito correttamente gli studenti " + v.toString() + " all'esame " + esame);
    }


    public void putAll(MultiMappa m) {
        //m --> multimappa
        for (String k : this.getEsami().keySet()) {
            if (m.getEsami().keySet().contains(k)) { //SE LE CHIAVI COINCIDONO
                for (List<Studente> s : m.getEsami().values()) { //PER OGNI LISTA DI STUDENTI NELLA NUOVA MAPPA
                    getEsami().merge(k, s, (s1, s2) -> {
                        if (!(s1.contains(s2))) {
                            s1.removeAll(s2);
                            s1.addAll(s2);
                            return s1;
                        }
                        return s1;
                    });
                }
            } else {
                getEsami().put(k, getEsami().get(k));
            }
        }
        //multimappa --> m
        for (String k : m.getEsami().keySet()) {
            if (getEsami().keySet().contains(k)) { //SE LE CHIAVI COINCIDONO
                for (List<Studente> s : getEsami().values()) { //PER OGNI LISTA DI STUDENTI NELLA NUOVA MAPPA
                    m.getEsami().merge(k, s, (s1, s2) -> {
                        if (!(s1.equals(s2))) {
                            s1.removeAll(s2);
                            s1.addAll(s2);
                            return s1;
                        }
                        return s1;
                    });
                }
            } else {
                getEsami().put(k, m.getEsami().get(k));
            }
        }
    }

    //removeAll(MultiMappa m) che rimuove tutte le chiavi della multimappa in input dalla mappa corrente
    public void removeAll(MultiMappa m) {
        for (String k : m.getEsami().keySet()) {
            if (getEsami().containsKey(k)) {
                getEsami().remove(k);
            }
        }
    }

    //get(k) che restituisce l'insieme dei valori associati alla chiave (suggerimento: vedere metodo getOrDefault)
    public List<Studente> get(String k) {
        return getEsami().getOrDefault(k, null);
    }

    //get(k, p) come get(k) ma restituisce solo i valori che soddisfano il predicato p
    public List<Studente> get(String k, String p) {
        List<Studente> ricerca = new ArrayList<>();
        for (String chiave : esami.keySet()) {
            if (chiave.equalsIgnoreCase(k)) {
                for (Studente st : esami.get(k)) {
                    if (st.getNome().contains(p)) {
                        ricerca.add(st);
                    }
                }
            }
        }
        return ricerca;
    }


    public HashMap<String, List<Studente>> getEsami() {
        return esami;
    }

    //keySet() che resituisce l'insieme delle chiavi contenute nella mappa
    public List<String> keySet() {
        List<String> result = new ArrayList<>();
        for (String k : esami.keySet()) {
            result.add(k);
        }
        return result;
    }

    //values() che restituisce l'elenco (con duplicati) dei valori contenuti nella multimappa

    public List<Studente> values() {
        List<Studente> result = new ArrayList<>();
        for (List<Studente> list : esami.values()) {
            result.addAll(list);
        }
        return result;
    }

    //values(cmp)che restituisce i valori ordinati secondo il metodo di comparazione passato in input
    public List<Studente> values(Comparator cmp) {
        List<Studente> result = values();
        result.sort(cmp.reversed());
        return result;
    }


    //valueSet() che restituisce l'insieme dei valori contenuti nella multimappa
    public Set<Studente> valueSet() {
        Set<Studente> result = new HashSet<>();
        for (List<Studente> list : esami.values()) {
            result.addAll(list);
        }
        return result;
    }

    //transformToMultiMappa(f) che restituisce una multimappa in cui le coppie (k, v) sono trasformate in (k, z) secondo una funzione (k, v) -> z (z può essere di tipo diverso rispetto a quello di v)
    public MultiMappa mapEach(BiFunction bf) {
        MultiMappa mm = new MultiMappa();
        List<Studente> list = new ArrayList<>();
        for (String k : esami.keySet()) {
            for (Studente st : esami.get(k)) {
                Studente z = (Studente) bf.apply(k, st);
                list.add(z);
            }
            mm.put(k, list);
        }
        return mm;
    }


    @Override
    public String toString() {
        return "MultiMappa{" +
                "esami=" + esami +
                '}';
    }


}