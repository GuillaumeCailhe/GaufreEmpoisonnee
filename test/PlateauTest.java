/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gaufreempoisonnee.model.Case;
import gaufreempoisonnee.model.Plateau;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author helgr
 */
@RunWith(Parameterized.class)
public class PlateauTest {

    @Parameter(0)
    public int hauteur;
    @Parameter(1)
    public int largeur;

    public PlateauTest() {
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{5, 3}, {3, 5}, {10, 10}, {0, 0}, {-1, -1}, {100, 100}};

        return Arrays.asList(data);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    // 
    /**
     * Teste le constructeur de la classe Plateau en s'assurant que : - Le
     * plateau ait la borne largeur et hauteur. - L'on ne puisse pas créer des
     * plateaux de taille nulle ou négative. - L'on ne puisse pas créer de
     * plateaux trop grands. - Le plateau contienne bien des cases gaufrées et
     * une case empoisonnée.
     */
    @Test
    public void testConstructeur() {
        if (this.hauteur < 1 || this.largeur < 1 || this.hauteur > 20 || this.largeur > 20) {
            this.largeur = 5;
            this.hauteur = 10;
        }

        Plateau plateauTest = new Plateau(this.hauteur, this.largeur);

        // Vérification sur la taille attendue du plateau.
        int l = plateauTest.getLargeur();
        int h = plateauTest.getHauteur();
        assertEquals(this.hauteur, h);
        assertEquals(this.largeur, l);

        // On vérifie que toutes les cases sont gaufrées, sauf la case du poison.
        for (int i = 0; i < this.hauteur; i++) {
            for (int j = 0; j < this.largeur; j++) {
                Case c = plateauTest.getPlateau()[i][j];
                if (i == this.hauteur - 1 && j == 0) {
                    assertEquals(Case.POISON, c);
                } else {
                    assertEquals(Case.GAUFRE, c);
                }
            }
        }
    }

    /**
     *
     */
    @Test
    public void testMangerMorceauDeGauffre() {
        /* A IMPLEMENTER */
    }

}
