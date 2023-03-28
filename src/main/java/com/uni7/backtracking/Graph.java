package com.uni7.backtracking;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
public class Graph {
    public List<Node> buscaEmRetrocesso(Node inicial, Node objetivo) {
        List<Node> LE = new ArrayList<>();
        LE.add(inicial);

        List<Node> BSS = new ArrayList<>();

        List<Node> LNE = new ArrayList<>();
        LNE.add(inicial);

        Node EC = inicial;

        while (!LNE.isEmpty()) {
            if (EC.equals(objetivo)) {
                return LE;
            }
            //verifica se os filhos está presente em BSS, LE e LNE
            if (EC.getChildren().stream().noneMatch(node -> !BSS.contains(node) && !LE.contains(node) && !LNE.contains(node))) {
                while (!LE.isEmpty() && EC.equals(LE.get(LE.size()- 1))) {
                    BSS.add(EC);
                    LE.remove(LE.get(LE.size()- 1));
                    LNE.remove(LNE.get(LNE.size()- 1));
                    EC = LNE.get(LNE.size()- 1);
                }
                LE.add(EC);
            } else {
                //adiciona filhos de EC, (exceto nó ja em BSS, LE, LNE) em LNE
                EC.getChildren().stream().filter(node -> !BSS.contains(node) && !LE.contains(node) && !LNE.contains(node)).forEach(LNE::add);
                EC = LNE.get(LNE.size() - 1);
                LE.add(EC);
            }
        }
        return LE;
    }
}
