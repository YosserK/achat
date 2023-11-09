package tn.esprit.rh.achat.test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {

    @InjectMocks
    private FactureServiceImpl factureService;

    @Mock
    private FactureRepository factureRepository;


    @Test
    public void addFactureTest() {

        Facture facture = new Facture();
        when(factureRepository.save(facture)).thenReturn(facture);
        Facture addedFacture = factureService.addFacture(facture);
        assertEquals(facture, addedFacture);

    }


}

