package hu.nye.progkor.crypto.controller;

import hu.nye.progkor.crypto.model.Crypto;
import hu.nye.progkor.crypto.service.CryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/api/v1/crypto")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping
    public List<Crypto> getAllCryptos() {

        return cryptoService.getAllCryptos();



    }

@GetMapping("/{id}")
    Crypto getCrypto(@PathVariable("id") final long id) {
        return cryptoService.getCrypto(id);
    }

    @PostMapping
    Crypto createCrypto(final @RequestBody Crypto crypto)  {
        return cryptoService.createCrypto(crypto);
    }

    @PutMapping
    Crypto updateCrypto(final @PathVariable Long id, final @RequestBody Crypto cryptoChange) {
        return cryptoService.updateCrypto(id,cryptoChange);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCrypto(final @PathVariable Long id) {
        cryptoService.deleteCrypto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
